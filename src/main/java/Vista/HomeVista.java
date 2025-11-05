
package Vista;

public class HomeVista extends javax.swing.JPanel {

    private String textoUser =      "En la sección de usuario, podrás agregar nuevos trabajadores con sus respectivos servicios.\n" +
                                    "Además un trabajador podrá ser seleccionado como administrador, siendo asignado un usuario\n" +
                                    "y contraseña. Podrás visualizer a todos los administradores, trabajadores registrados.";
    private String textoService =   "En el apartado de servicios, podrás registrar lo siguiente: Qué servicios realizó el trabajador, \n" +
                                    "Quién fue su cliente, Cuántos productos se vendieron en el servicio. Además, podrás realizer\n" +
                                    "busquedas por cliente, servicios, trabajador, etc.";
    private String textoComision =  "Podrás ajustar la comisión de tus trabajadores a la semana. Además, los días no laborales y\n" +
                                    "feriados podrán ser ajustados para que cuenten con un porcentaje de comisión del 50%.";
    private String textoIncident =  "En Incidencias, podrás manejar la situación de la insatisfacción cliente, el reclamo de este\n" +
                                    "será analizado por un administrador y será catalogado como incidencia baja, media o grave.\n" +
                                    "De acuerdo al tipo de incidencia seleccionada, se podrán elegir acciones como el descuento al \n" +
                                    "trabajador.";
    private String textoReport =    "Los reportes serán una pieza clave para la toma de decisiones para los dueños del negocio, estos\n" +
                                    "reports mostrarán cuánto vendió un trabajador, cuántos servicios se efectuarón y más. Los reports\n" +
                                    "podrán exportarse en formato PDF.";
    
    public HomeVista() {
        initComponents();
        SetTextJustify();
    }

    public String StrToHTML(String txt) {
        return "<html><p style='text-align:justify'>" + txt + "</p></html>";
    }
    
    private void SetTextJustify() {
        txtParagraphUser.setText(StrToHTML(textoUser));
        txtParagraphComision.setText(StrToHTML(textoComision));
        txtParagraphIncident.setText(StrToHTML(textoIncident));
        txtParagraphReport.setText(StrToHTML(textoReport));
        txtParagraphService.setText(StrToHTML(textoService));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlContainerHome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlInfoUsers = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtParagraphUser = new javax.swing.JLabel();
        pnlInfoServices = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtParagraphService = new javax.swing.JLabel();
        pnlInfoComision = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtParagraphComision = new javax.swing.JLabel();
        pnlInfoIncident = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtParagraphIncident = new javax.swing.JLabel();
        pnlInfoReport = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtParagraphReport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 244, 236));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("¡ BIENVENIDO AL PANEL DE ADMINISTRACIÓN !");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        pnlContainerHome.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlContainerHome.setPreferredSize(new java.awt.Dimension(1096, 530));
        pnlContainerHome.setRequestFocusEnabled(false);
        pnlContainerHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("EN EL PANEL ENCONTRARÁS:");
        pnlContainerHome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnlInfoUsers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlInfoUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlInfoUsers.setEnabled(false);
        pnlInfoUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconUserControlv2.png"))); // NOI18N
        jLabel2.setText("Usuario");
        jLabel2.setIconTextGap(10);
        pnlInfoUsers.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtParagraphUser.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtParagraphUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtParagraphUser.setToolTipText("");
        txtParagraphUser.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txtParagraphUser.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlInfoUsers.add(txtParagraphUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 277, 120));

        pnlContainerHome.add(pnlInfoUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 300, 180));

        pnlInfoServices.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlInfoServices.setEnabled(false);
        pnlInfoServices.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconServiceRegistrationv2.png"))); // NOI18N
        jLabel4.setText("Servicios");
        jLabel4.setIconTextGap(10);
        pnlInfoServices.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtParagraphService.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtParagraphService.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtParagraphService.setToolTipText("");
        txtParagraphService.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txtParagraphService.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlInfoServices.add(txtParagraphService, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 277, 120));

        pnlContainerHome.add(pnlInfoServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 300, 180));

        pnlInfoComision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlInfoComision.setEnabled(false);
        pnlInfoComision.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconComisionv2.png"))); // NOI18N
        jLabel5.setText("Comisiones");
        jLabel5.setIconTextGap(10);
        pnlInfoComision.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtParagraphComision.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtParagraphComision.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtParagraphComision.setToolTipText("");
        txtParagraphComision.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txtParagraphComision.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlInfoComision.add(txtParagraphComision, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 277, 120));

        pnlContainerHome.add(pnlInfoComision, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 300, 180));

        pnlInfoIncident.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlInfoIncident.setEnabled(false);
        pnlInfoIncident.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconIncidentv2.png"))); // NOI18N
        jLabel6.setText("Incidencias");
        jLabel6.setIconTextGap(10);
        pnlInfoIncident.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtParagraphIncident.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtParagraphIncident.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtParagraphIncident.setToolTipText("");
        txtParagraphIncident.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txtParagraphIncident.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlInfoIncident.add(txtParagraphIncident, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 277, 120));

        pnlContainerHome.add(pnlInfoIncident, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 300, 180));

        pnlInfoReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlInfoReport.setEnabled(false);
        pnlInfoReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconReportv2.png"))); // NOI18N
        jLabel7.setText("Reportes");
        jLabel7.setIconTextGap(10);
        pnlInfoReport.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtParagraphReport.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtParagraphReport.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtParagraphReport.setToolTipText("");
        txtParagraphReport.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txtParagraphReport.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnlInfoReport.add(txtParagraphReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 277, 120));

        pnlContainerHome.add(pnlInfoReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 300, 180));

        add(pnlContainerHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1096, 530));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel pnlContainerHome;
    private javax.swing.JPanel pnlInfoComision;
    private javax.swing.JPanel pnlInfoIncident;
    private javax.swing.JPanel pnlInfoReport;
    private javax.swing.JPanel pnlInfoServices;
    private javax.swing.JPanel pnlInfoUsers;
    private javax.swing.JLabel txtParagraphComision;
    private javax.swing.JLabel txtParagraphIncident;
    private javax.swing.JLabel txtParagraphReport;
    private javax.swing.JLabel txtParagraphService;
    private javax.swing.JLabel txtParagraphUser;
    // End of variables declaration//GEN-END:variables
}
