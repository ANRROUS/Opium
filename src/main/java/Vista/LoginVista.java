package Vista;

import Implementación.AdminMethod;
import Implementación.EmpMethod;
import Modelo.Empleado;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginVista extends javax.swing.JFrame {

    //  Variables de barra superior
    EmpMethod emp = new EmpMethod();
    int xMouse, yMouse;

    public LoginVista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlTitleBar = new javax.swing.JPanel();
        btnCloseTab = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLoginUsername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtLoginPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        pnlBtnLogin = new javax.swing.JPanel();
        btnTxtLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(255, 255, 255));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loginimg.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        pnlBackground.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 770));

        pnlTitleBar.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitleBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlTitleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTitleBarMouseDragged(evt);
            }
        });
        pnlTitleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTitleBarMousePressed(evt);
            }
        });

        btnCloseTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconX.png"))); // NOI18N
        btnCloseTab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCloseTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseTabMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlTitleBarLayout = new javax.swing.GroupLayout(pnlTitleBar);
        pnlTitleBar.setLayout(pnlTitleBarLayout);
        pnlTitleBarLayout.setHorizontalGroup(
            pnlTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleBarLayout.createSequentialGroup()
                .addContainerGap(1313, Short.MAX_VALUE)
                .addComponent(btnCloseTab)
                .addGap(13, 13, 13))
        );
        pnlTitleBarLayout.setVerticalGroup(
            pnlTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCloseTab)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBackground.add(pnlTitleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logov1.png"))); // NOI18N
        pnlBackground.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel4.setText("USUARIO:");
        pnlBackground.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 170, -1));

        txtLoginUsername.setForeground(new java.awt.Color(101, 101, 101));
        txtLoginUsername.setText("Ingrese su usuario de administrador");
        txtLoginUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(255, 255, 255)));
        txtLoginUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLoginUsernameMousePressed(evt);
            }
        });
        pnlBackground.add(txtLoginUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 330, 430, 40));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBackground.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 430, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel2.setText("CONTRASEÑA:");
        pnlBackground.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, 170, -1));

        txtLoginPassword.setForeground(new java.awt.Color(101, 101, 101));
        txtLoginPassword.setText("*********************");
        txtLoginPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 10, 0, 0, new java.awt.Color(255, 255, 255)));
        txtLoginPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLoginPasswordMousePressed(evt);
            }
        });
        pnlBackground.add(txtLoginPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 430, 40));

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBackground.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 510, 430, -1));

        pnlBtnLogin.setBackground(new java.awt.Color(255, 192, 211));

        btnTxtLogin.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        btnTxtLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtLogin.setText("INGRESAR");
        btnTxtLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtLoginMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnLoginLayout = new javax.swing.GroupLayout(pnlBtnLogin);
        pnlBtnLogin.setLayout(pnlBtnLoginLayout);
        pnlBtnLoginLayout.setHorizontalGroup(
            pnlBtnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTxtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        pnlBtnLoginLayout.setVerticalGroup(
            pnlBtnLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTxtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlBackground.add(pnlBtnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 610, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnlTitleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleBarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlTitleBarMousePressed

    private void pnlTitleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_pnlTitleBarMouseDragged

    private void btnCloseTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseTabMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCloseTabMouseClicked

    private void btnTxtLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtLoginMouseEntered
        pnlBtnLogin.setBackground(new Color(255, 161, 189));
    }//GEN-LAST:event_btnTxtLoginMouseEntered

    private void btnTxtLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtLoginMouseExited
        pnlBtnLogin.setBackground(new Color(255, 192, 211));
    }//GEN-LAST:event_btnTxtLoginMouseExited

    private void txtLoginUsernameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLoginUsernameMousePressed
        if (txtLoginUsername.getText().equals("Ingrese su usuario de administrador")) {
            txtLoginUsername.setText("");
            txtLoginUsername.setForeground(Color.black);
        }
        if (String.valueOf(txtLoginPassword.getPassword()).isEmpty()) {
            txtLoginPassword.setText("*********************");
            txtLoginPassword.setForeground(new Color(101, 101, 101));
        }
    }//GEN-LAST:event_txtLoginUsernameMousePressed

    private void txtLoginPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLoginPasswordMousePressed
        if (String.valueOf(txtLoginPassword.getPassword()).equals("*********************")) {
            txtLoginPassword.setText("");
            txtLoginPassword.setForeground(Color.black);
        }
        if (txtLoginUsername.getText().isEmpty()) {
            txtLoginUsername.setText("Ingrese su usuario de administrador");
            txtLoginUsername.setForeground(new Color(101, 101, 101));
        }
    }//GEN-LAST:event_txtLoginPasswordMousePressed

    private void btnTxtLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtLoginMouseClicked
        String usuario = txtLoginUsername.getText();
        String password = new String(txtLoginPassword.getPassword()); // Cambia a usar el método getPassword()

        AdminMethod admin = new AdminMethod();
        
        int idEmpleado = admin.iniciarSesion(usuario, password);

        try {
            if (idEmpleado == 0) {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            } else {
                MenuPrincipal home = new MenuPrincipal();
                home.setVisible(true);
                home.txtNameAdmin.setText("Hola, "+emp.obtenerEmpleado(idEmpleado).getNombreEmpleado());
                dispose();
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginVista.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado");
        }
    }//GEN-LAST:event_btnTxtLoginMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCloseTab;
    private javax.swing.JLabel btnTxtLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlBtnLogin;
    private javax.swing.JPanel pnlTitleBar;
    private javax.swing.JPasswordField txtLoginPassword;
    private javax.swing.JTextField txtLoginUsername;
    // End of variables declaration//GEN-END:variables
}
