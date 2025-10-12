package com.raven.component;

import com.raven.swing.MyTextField;
import com.raven.swing.MyPasswordField;
import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import com.raven.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import com.raven.database.MiConexion;


public class PanelLoginAndRegister extends javax.swing.JLayeredPane {
private MyTextField txtLoginEmail;
private MyPasswordField txtLoginPass;
    public PanelLoginAndRegister() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }

   private void initRegister() {
    register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));

    JLabel label = new JLabel("Crear Cuenta");
    label.setFont(new Font("sansserif", Font.BOLD, 30));
    label.setForeground(new Color(7, 164, 121));
    register.add(label);

    // Campo Nombre
    MyTextField txtUser = new MyTextField();
    txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/user.png")));
    txtUser.setHint("Nombre");
    register.add(txtUser, "w 60%");

    // Campo Correo
    MyTextField txtEmail = new MyTextField();
    txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
    txtEmail.setHint("Correo");
    register.add(txtEmail, "w 60%");

    // Campo Contraseña
    MyPasswordField txtPass = new MyPasswordField();
    txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
    txtPass.setHint("Contraseña");
    register.add(txtPass, "w 60%");

    // Botón Registrar
    Button cmd = new Button();
    cmd.setBackground(new Color(7, 164, 121));
    cmd.setForeground(new Color(250, 250, 250));
    cmd.setText("Registrar");
    register.add(cmd, "w 40%, h 40");

    // Acción del botón
    cmd.addActionListener(e -> {
        String nombre = txtUser.getText().trim();
        String correo = txtEmail.getText().trim();
        String contraseña = new String(txtPass.getPassword()).trim();

        if (nombre.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }

        if (!correo.endsWith("@ms.upla.edu.pe")) {
            JOptionPane.showMessageDialog(this, "Solo se permiten correos institucionales (@ms.upla.edu.pe).");
            return;
        }

        boolean registrado = com.raven.database.MiConexion.registrarUsuario(nombre, correo, contraseña);

        if (registrado) {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");
            showRegister(false); // Cambia a la vista de login
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar usuario.");
        }
    });
}
    
   private void initLogin() {
    login.setLayout(new net.miginfocom.swing.MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));

    JLabel label = new JLabel("Iniciar Sesión");
    label.setFont(new Font("sansserif", Font.BOLD, 30));
    label.setForeground(new Color(7, 164, 121));
    login.add(label);

    // Campo de correo
    txtLoginEmail = new MyTextField();
    txtLoginEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/mail.png")));
    txtLoginEmail.setHint("Correo");
    login.add(txtLoginEmail, "w 60%");

    // Campo de contraseña
    txtLoginPass = new MyPasswordField();
    txtLoginPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
    txtLoginPass.setHint("Contraseña");
    login.add(txtLoginPass, "w 60%");

    // Botón "¿Olvidó su contraseña?"
    JButton cmdForget = new JButton("¿Olvidó su contraseña?");
    cmdForget.setForeground(new Color(100, 100, 100));
    cmdForget.setFont(new Font("sansserif", Font.BOLD, 12));
    cmdForget.setContentAreaFilled(false);
    cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
    login.add(cmdForget);

    // Botón de iniciar sesión
    Button cmd = new Button();
    cmd.setBackground(new Color(7, 164, 121));
    cmd.setForeground(new Color(250, 250, 250));
    cmd.setText("Iniciar Sesión");
    login.add(cmd, "w 40%, h 40");

    // Acción del botón
    cmd.addActionListener(e -> {
        String correo = txtLoginEmail.getText().trim();
        String contraseña = new String(txtLoginPass.getPassword()).trim();

        if (correo.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
            return;
        }

        if (!correo.endsWith("@ms.upla.edu.pe")) {
            JOptionPane.showMessageDialog(this, "Debe usar su correo institucional (@ms.upla.edu.pe).");
            return;
        }

        boolean loginExitoso = com.raven.database.MiConexion.iniciarSesion(correo, contraseña);

        if (loginExitoso) {
            JOptionPane.showMessageDialog(this, "✅ Inicio de sesión exitoso. ¡Bienvenido!");
            // Aquí puedes abrir otra ventana o cambiar de panel
            // Por ejemplo: new VentanaPrincipal().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "❌ Correo o contraseña incorrectos.");
        }
    });
}

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
