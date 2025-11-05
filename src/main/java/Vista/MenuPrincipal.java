package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipal extends javax.swing.JFrame {

    //  Variables de barra superior
    int xMouse, yMouse;

    public MenuPrincipal() {
        initComponents();
        setDate();
        initContentPanel();
    }

    private void initContentPanel() {
        ShowPanel(new HomeVista());
    }

    // Método para cargar un nuevo panel
    private void ShowPanel(JPanel pnl) {
        pnl.setSize(1096, 600);
        pnl.setLocation(0, 0);

        pnlContent.removeAll();
        pnlContent.add(pnl, BorderLayout.CENTER);
        pnlContent.revalidate();
        pnlContent.repaint();
    }

    // Método para fecha actual
    private void setDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        txtDatetext.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'del' yyyy", spanishLocale)));
    }

    private void cuadroSalirOCerrarSesion() {
        JDialog dialogo = new JDialog(this, "Confirmar Acción", true); // 'true' para hacerlo modal
        dialogo.setSize(300, 180);
        dialogo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel para el mensaje
        JPanel panelMensaje = new JPanel();
        JLabel label = new JLabel("¿Qué acción desea realizar?");
        panelMensaje.add(label);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Agrega márgenes alrededor del mensaje
        dialogo.add(panelMensaje, gbc);

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centrar y dar espacio entre botones

        // Botón cerrar sesión
        JButton btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(e -> {
            dialogo.dispose();
            dispose();
            LoginVista open = new LoginVista();
            open.setVisible(true);
        });

        // Botón salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            dialogo.dispose();
            System.exit(0);
        });

        panelBotones.add(btnCerrarSesion);
        panelBotones.add(btnSalir);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10); // Agrega márgenes alrededor de los botones
        gbc.anchor = GridBagConstraints.CENTER;
        dialogo.add(panelBotones, gbc);

        // Configuración final del cuadro de diálogo
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        pnlSideBarMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlContainerBtn1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        pnlContainerBtn2 = new javax.swing.JPanel();
        btnUserControl = new javax.swing.JLabel();
        pnlContainerBtn3 = new javax.swing.JPanel();
        btnServiceRegistration = new javax.swing.JLabel();
        pnlContainerBtn4 = new javax.swing.JPanel();
        btnComision = new javax.swing.JLabel();
        pnlContainerBtn5 = new javax.swing.JPanel();
        btnIncident = new javax.swing.JLabel();
        pnlContainerBtn6 = new javax.swing.JPanel();
        btnReport = new javax.swing.JLabel();
        pnlTitleBar = new javax.swing.JPanel();
        btnCloseTab = new javax.swing.JLabel();
        txtNameAdmin = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        txtNavtext = new javax.swing.JLabel();
        txtDatetext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnlBackground.setBackground(new java.awt.Color(248, 244, 236));
        pnlBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSideBarMenu.setBackground(new java.awt.Color(82, 74, 78));
        pnlSideBarMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logov2.png"))); // NOI18N
        pnlSideBarMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 34, -1, -1));
        pnlSideBarMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 270, 10));

        pnlContainerBtn1.setBackground(new java.awt.Color(82, 74, 78));

        btnHome.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconHome.png"))); // NOI18N
        btnHome.setText("Inicio");
        btnHome.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(82, 74, 78)));
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.setIconTextGap(10);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerBtn1Layout = new javax.swing.GroupLayout(pnlContainerBtn1);
        pnlContainerBtn1.setLayout(pnlContainerBtn1Layout);
        pnlContainerBtn1Layout.setHorizontalGroup(
            pnlContainerBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlContainerBtn1Layout.setVerticalGroup(
            pnlContainerBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlSideBarMenu.add(pnlContainerBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 270, 60));

        pnlContainerBtn2.setBackground(new java.awt.Color(82, 74, 78));

        btnUserControl.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnUserControl.setForeground(new java.awt.Color(255, 255, 255));
        btnUserControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconUserControl.png"))); // NOI18N
        btnUserControl.setText("Usuarios");
        btnUserControl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(82, 74, 78)));
        btnUserControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserControl.setIconTextGap(10);
        btnUserControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserControlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUserControlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUserControlMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerBtn2Layout = new javax.swing.GroupLayout(pnlContainerBtn2);
        pnlContainerBtn2.setLayout(pnlContainerBtn2Layout);
        pnlContainerBtn2Layout.setHorizontalGroup(
            pnlContainerBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUserControl, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlContainerBtn2Layout.setVerticalGroup(
            pnlContainerBtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUserControl, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlSideBarMenu.add(pnlContainerBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 270, 60));

        pnlContainerBtn3.setBackground(new java.awt.Color(82, 74, 78));

        btnServiceRegistration.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnServiceRegistration.setForeground(new java.awt.Color(255, 255, 255));
        btnServiceRegistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconServiceRegistration.png"))); // NOI18N
        btnServiceRegistration.setText("Servicios");
        btnServiceRegistration.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(82, 74, 78)));
        btnServiceRegistration.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServiceRegistration.setIconTextGap(10);
        btnServiceRegistration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnServiceRegistrationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnServiceRegistrationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServiceRegistrationMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerBtn3Layout = new javax.swing.GroupLayout(pnlContainerBtn3);
        pnlContainerBtn3.setLayout(pnlContainerBtn3Layout);
        pnlContainerBtn3Layout.setHorizontalGroup(
            pnlContainerBtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnServiceRegistration, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlContainerBtn3Layout.setVerticalGroup(
            pnlContainerBtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnServiceRegistration, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlSideBarMenu.add(pnlContainerBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 270, 60));

        pnlContainerBtn4.setBackground(new java.awt.Color(82, 74, 78));

        btnComision.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnComision.setForeground(new java.awt.Color(255, 255, 255));
        btnComision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconComision.png"))); // NOI18N
        btnComision.setText("Comisiones");
        btnComision.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(82, 74, 78)));
        btnComision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComision.setIconTextGap(10);
        btnComision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComisionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComisionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnComisionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerBtn4Layout = new javax.swing.GroupLayout(pnlContainerBtn4);
        pnlContainerBtn4.setLayout(pnlContainerBtn4Layout);
        pnlContainerBtn4Layout.setHorizontalGroup(
            pnlContainerBtn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnComision, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlContainerBtn4Layout.setVerticalGroup(
            pnlContainerBtn4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnComision, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlSideBarMenu.add(pnlContainerBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 270, 60));

        pnlContainerBtn5.setBackground(new java.awt.Color(82, 74, 78));

        btnIncident.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnIncident.setForeground(new java.awt.Color(255, 255, 255));
        btnIncident.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconIncident.png"))); // NOI18N
        btnIncident.setText("Incidencias");
        btnIncident.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(82, 74, 78)));
        btnIncident.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIncident.setIconTextGap(10);
        btnIncident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIncidentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIncidentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIncidentMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerBtn5Layout = new javax.swing.GroupLayout(pnlContainerBtn5);
        pnlContainerBtn5.setLayout(pnlContainerBtn5Layout);
        pnlContainerBtn5Layout.setHorizontalGroup(
            pnlContainerBtn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIncident, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlContainerBtn5Layout.setVerticalGroup(
            pnlContainerBtn5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIncident, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlSideBarMenu.add(pnlContainerBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 270, -1));

        pnlContainerBtn6.setBackground(new java.awt.Color(82, 74, 78));

        btnReport.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconReport.png"))); // NOI18N
        btnReport.setText("Reportes");
        btnReport.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(82, 74, 78)));
        btnReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReport.setIconTextGap(10);
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlContainerBtn6Layout = new javax.swing.GroupLayout(pnlContainerBtn6);
        pnlContainerBtn6.setLayout(pnlContainerBtn6Layout);
        pnlContainerBtn6Layout.setHorizontalGroup(
            pnlContainerBtn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlContainerBtn6Layout.setVerticalGroup(
            pnlContainerBtn6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlSideBarMenu.add(pnlContainerBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 270, 60));

        pnlBackground.add(pnlSideBarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 770));

        pnlTitleBar.setBackground(new java.awt.Color(248, 244, 236));
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
                .addContainerGap(1315, Short.MAX_VALUE)
                .addComponent(btnCloseTab, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlTitleBarLayout.setVerticalGroup(
            pnlTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCloseTab)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBackground.add(pnlTitleBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        txtNameAdmin.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        txtNameAdmin.setText("Nombre del Administrador");
        txtNameAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameAdminMouseClicked(evt);
            }
        });
        pnlBackground.add(txtNameAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 600, 30));

        pnlContent.setBackground(new java.awt.Color(248, 244, 236));

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1096, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pnlBackground.add(pnlContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 1096, 600));

        pnlHeader.setBackground(new java.awt.Color(255, 192, 211));
        pnlHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNavtext.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        txtNavtext.setText("Inicio");
        pnlHeader.add(txtNavtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 370, -1));

        txtDatetext.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        txtDatetext.setText("Hoy es {dayname} {day} de {month} del {year}");
        pnlHeader.add(txtDatetext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 320, -1));

        pnlBackground.add(pnlHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 1096, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseTabMouseClicked
        cuadroSalirOCerrarSesion();
    }//GEN-LAST:event_btnCloseTabMouseClicked

    private void pnlTitleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleBarMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlTitleBarMousePressed

    private void pnlTitleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_pnlTitleBarMouseDragged

    private void btnServiceRegistrationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceRegistrationMouseEntered
        pnlContainerBtn3.setBackground(new Color(128, 116, 122));
    }//GEN-LAST:event_btnServiceRegistrationMouseEntered

    private void btnServiceRegistrationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceRegistrationMouseExited
        pnlContainerBtn3.setBackground(new Color(82, 74, 78));
    }//GEN-LAST:event_btnServiceRegistrationMouseExited

    private void btnUserControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserControlMouseEntered
        pnlContainerBtn2.setBackground(new Color(128, 116, 122));
    }//GEN-LAST:event_btnUserControlMouseEntered

    private void btnUserControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserControlMouseExited
        pnlContainerBtn2.setBackground(new Color(82, 74, 78));
    }//GEN-LAST:event_btnUserControlMouseExited

    private void btnComisionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComisionMouseEntered
        pnlContainerBtn4.setBackground(new Color(128, 116, 122));
    }//GEN-LAST:event_btnComisionMouseEntered

    private void btnComisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComisionMouseExited
        pnlContainerBtn4.setBackground(new Color(82, 74, 78));
    }//GEN-LAST:event_btnComisionMouseExited

    private void btnReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseEntered
        pnlContainerBtn6.setBackground(new Color(128, 116, 122));
    }//GEN-LAST:event_btnReportMouseEntered

    private void btnReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseExited
        pnlContainerBtn6.setBackground(new Color(82, 74, 78));
    }//GEN-LAST:event_btnReportMouseExited

    private void btnServiceRegistrationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServiceRegistrationMouseClicked
        ShowPanel(new ReciboVista());
        txtNavtext.setText("Registro de Servicios");
    }//GEN-LAST:event_btnServiceRegistrationMouseClicked

    private void btnUserControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserControlMouseClicked
        ShowPanel(new UsuariosVista());
        txtNavtext.setText("Control de Usuarios");
    }//GEN-LAST:event_btnUserControlMouseClicked

    private void btnComisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComisionMouseClicked
        ShowPanel(new ComisionVista());
        txtNavtext.setText("Cálculo de Comisiones");
    }//GEN-LAST:event_btnComisionMouseClicked

    private void btnReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseClicked
        ShowPanel(new ReporteVista());
        txtNavtext.setText("Reportes");
    }//GEN-LAST:event_btnReportMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        ShowPanel(new HomeVista());
        txtNavtext.setText("Inicio");
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        pnlContainerBtn1.setBackground(new Color(128, 116, 122));
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        pnlContainerBtn1.setBackground(new Color(82, 74, 78));
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnIncidentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncidentMouseClicked
        ShowPanel(new IncidenciaVista());
        txtNavtext.setText("Registrar Incidencia");
    }//GEN-LAST:event_btnIncidentMouseClicked

    private void btnIncidentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncidentMouseEntered
        pnlContainerBtn5.setBackground(new Color(128, 116, 122));
    }//GEN-LAST:event_btnIncidentMouseEntered

    private void btnIncidentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIncidentMouseExited
        pnlContainerBtn5.setBackground(new Color(82, 74, 78));
    }//GEN-LAST:event_btnIncidentMouseExited

    private void txtNameAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameAdminMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameAdminMouseClicked

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCloseTab;
    private javax.swing.JLabel btnComision;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnIncident;
    private javax.swing.JLabel btnReport;
    private javax.swing.JLabel btnServiceRegistration;
    private javax.swing.JLabel btnUserControl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlContainerBtn1;
    private javax.swing.JPanel pnlContainerBtn2;
    private javax.swing.JPanel pnlContainerBtn3;
    private javax.swing.JPanel pnlContainerBtn4;
    private javax.swing.JPanel pnlContainerBtn5;
    private javax.swing.JPanel pnlContainerBtn6;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlSideBarMenu;
    private javax.swing.JPanel pnlTitleBar;
    private javax.swing.JLabel txtDatetext;
    protected javax.swing.JLabel txtNameAdmin;
    private javax.swing.JLabel txtNavtext;
    // End of variables declaration//GEN-END:variables
}
