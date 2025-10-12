package com.raven.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MiConexion {

    private static final String URL = "jdbc:mysql://localhost:3306/usuarios_db";
    private static final String USER = "root"; // Cambia si usas otro usuario
    private static final String PASSWORD = "diegoalonso2500"; // Cambia por tu contraseña real

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }

    public static boolean registrarUsuario(String nombre, String correo, String contraseña) {
        String sql = "INSERT INTO usuarios (nombre, correo, contraseña) VALUES (?, ?, ?)";
        Connection conn = conectar();

        if (conn == null) {
            System.out.println("No se pudo establecer conexión con la base de datos.");
            return false;
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contraseña);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public static boolean iniciarSesion(String correo, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contraseña = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);
            stmt.setString(2, contraseña);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Si hay resultado, el login es válido

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            return false;
        }
    }
}