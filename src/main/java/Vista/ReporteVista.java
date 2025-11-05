package Vista;

import SQL_Conection.SQL_Conexion;
import Implementación.ReportesMethod;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ReporteVista extends javax.swing.JPanel {

    ReportesMethod rep = new ReportesMethod();
    
    DefaultTableModel tblProductos = new DefaultTableModel();

    public ReporteVista() {
        initComponents();
        cargarTablaProductos();
        disenoTablas();
        mostrarBarChartExperiencia();
        mostrarPieChart();
        mostrarBarChartServicios();
    }

    private void disenoTablas() {
        tblWorkerReport.setRowHeight(30);
        tblWorkerReport.getTableHeader().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblWorkerReport.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
    }

    private ResultSet consultaProducto() {
        ResultSet rs = null;
        try {
            Connection conexion = SQL_Conexion.conectar();
            //Consulta
            String consulta = "SELECT e.nombreEmpleado, SUM(r.nproductoVendido * 5) AS totalGanado "
                    + "FROM recibo r "
                    + "JOIN empleado e ON r.idEmpleado = e.idEmpleado "
                    + "GROUP BY e.nombreEmpleado";
            PreparedStatement st = conexion.prepareStatement(consulta);
            rs = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private void cargarTablaProductos() {
        try {
            ResultSet rs = consultaProducto();
            tblProductos.addColumn("Nombre del Empleado");
            tblProductos.addColumn("Ganancio total de los productos");
            while (rs.next()) {
                String nombreEmpleado = rs.getString("nombreEmpleado");
                int totalGanado = rs.getInt("totalGanado");

                Object[] fila = {nombreEmpleado, totalGanado};
                tblProductos.addRow(fila);
            }

            tblWorkerReport.setModel(tblProductos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet consultaBarcChartExperiencia() {
        ResultSet rs = null;
        try {
            Connection conexion = SQL_Conexion.conectar();
            //Consulta
            String consulta = "SELECT nombreEmpleado, añosExperiencia FROM empleado";
            PreparedStatement st = conexion.prepareStatement(consulta);
            rs = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaBarChartServicios() {
        ResultSet rs = null;
        try {
            Connection conexion = SQL_Conexion.conectar();
            // consulta para agrupar en función de nombreServicio y sumar el precio
            String consulta = "SELECT nombreServicio, SUM(precio) AS totalGanado FROM servicio GROUP BY nombreServicio";
            PreparedStatement st = conexion.prepareStatement(consulta);
            rs = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet consultaPieChart() {
        ResultSet rs = null;
        try {
            Connection conexion = SQL_Conexion.conectar();
            //Consulta
            String consulta = "SELECT e.nombreEmpleado, SUM(p.comisionSemanal) AS totalPagado "
                    + "FROM pagos p "
                    + "JOIN empleado e ON p.idEmpleado = e.idEmpleado "
                    + "GROUP BY e.nombreEmpleado";
            PreparedStatement st = conexion.prepareStatement(consulta);
            rs = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void mostrarBarChartServicios() {
        try {
            ResultSet rs = consultaBarChartServicios();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            while (rs.next()) {
                String nombreServicio = rs.getString("nombreServicio");
                double totalGanado = rs.getDouble("totalGanado");
                dataset.addValue(totalGanado, "Total Ganado", nombreServicio);
            }
            rs.close(); // Cerrar ResultSet

            JFreeChart chart = ChartFactory.createBarChart(
                    "Ganancias por Servicio",
                    "Servicio",
                    "Total Ganado",
                    dataset,
                    PlotOrientation.HORIZONTAL,
                    false,
                    true,
                    false
            );

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(700, 390));
            pnlChart.setLayout(new BorderLayout()); // Establecer BorderLayout
            pnlChart.removeAll();
            pnlChart.add(chartPanel, BorderLayout.CENTER); // Agregar al centro
            pnlChart.revalidate();
            pnlChart.repaint();

            String rutaImagen = "D:\\ESTUDIOS 2024\\CICLO 2\\Curso Integrador I\\Avance codigo\\CODIGO AC\\ProyectoIntegrador (1)\\ProyectoIntegrador\\ProyectoIntegrador\\src\\main\\resources\\Imagenes\\graficos\\graficoServicios.png";
            ChartUtilities.saveChartAsPNG(new File(rutaImagen), chart, 500, 250);

            // Verificar si la imagen fue generada
            File archivoImagen = new File(rutaImagen);
            if (archivoImagen.exists() && archivoImagen.isFile()) {
                System.out.println("El grafico de servicios se genero correctamente en la carpeta como imagen.");
            } else {
                System.out.println("Error: No se genero la imagen de servicios");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarPieChart() {
        try {
            ResultSet rs = consultaPieChart();
            DefaultPieDataset dataset = new DefaultPieDataset();

            while (rs.next()) {
                String nombreEmpleado = rs.getString("nombreEmpleado");
                double totalPagado = rs.getDouble("totalPagado");
                System.out.println("Empleado: " + nombreEmpleado + " - Total Pagado: " + totalPagado); // Verificación
                dataset.setValue(nombreEmpleado, totalPagado);
            }
            rs.close(); // Cerrar ResultSet

            JFreeChart chart = ChartFactory.createPieChart(
                    "Pagos de trabajadores",
                    dataset,
                    false,
                    true,
                    false
            );

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(700, 390));
            pnlChart.setLayout(new BorderLayout());
            pnlChart.removeAll();
            pnlChart.add(chartPanel, BorderLayout.CENTER);
            pnlChart.revalidate();
            pnlChart.repaint();

            String rutaImagen = "D:\\ESTUDIOS 2024\\CICLO 2\\Curso Integrador I\\Avance codigo\\CODIGO AC\\ProyectoIntegrador (1)\\ProyectoIntegrador\\ProyectoIntegrador\\src\\main\\resources\\Imagenes\\graficos\\pagosTrabajador.png";
            ChartUtilities.saveChartAsPNG(new File(rutaImagen), chart, 500, 250);

            // Verificar si la imagen fue generada
            File archivoImagen = new File(rutaImagen);
            if (archivoImagen.exists() && archivoImagen.isFile()) {
                System.out.println("El grafico de pagos se genero correctamente en la carpeta como imagen.");
            } else {
                System.out.println("Error: No se genero la imagen de pagos");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarBarChartExperiencia() {
        try {
            ResultSet rs = consultaBarcChartExperiencia();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            while (rs.next()) {
                String nombreEmpleado = rs.getString("nombreEmpleado");
                int añosExperiencia = rs.getInt("añosExperiencia");
                System.out.println("Empleado: " + nombreEmpleado + " - Años de Experiencia: " + añosExperiencia); // Verificación
                dataset.addValue(añosExperiencia, "Años de Experiencia", nombreEmpleado);
            }
            rs.close(); // Cerrar ResultSet

            JFreeChart chart = ChartFactory.createBarChart(
                    "Años de experiencia",
                    "Empleado",
                    "Experiencia en años",
                    dataset,
                    PlotOrientation.HORIZONTAL, // Cambiar a VERTICAL si prefieres
                    false,
                    true,
                    false
            );

            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(700, 390));
            pnlChart.setLayout(new BorderLayout());
            pnlChart.removeAll();
            pnlChart.add(chartPanel, BorderLayout.CENTER);
            pnlChart.revalidate();
            pnlChart.repaint();

            String rutaImagen = "D:\\ESTUDIOS 2024\\CICLO 2\\Curso Integrador I\\Avance codigo\\CODIGO AC\\ProyectoIntegrador (1)\\ProyectoIntegrador\\ProyectoIntegrador\\src\\main\\resources\\Imagenes\\graficos\\graficoExperiencia.png";
            ChartUtilities.saveChartAsPNG(new File(rutaImagen), chart, 500, 250);

            // Verificar si la imagen fue generada
            File archivoImagen = new File(rutaImagen);
            if (archivoImagen.exists() && archivoImagen.isFile()) {
                System.out.println("El grafico de experiencia se genero correctamente en la carpeta como imagen.");
            } else {
                System.out.println("Error: No se genero la imagen de experiencia");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlChartReport = new javax.swing.JPanel();
        pnlChart = new javax.swing.JPanel();
        txtTitleChart = new javax.swing.JLabel();
        cboSelectChart = new javax.swing.JComboBox<>();
        pnlUserReport = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkerReport = new javax.swing.JTable();
        pnlExportBtn = new javax.swing.JPanel();
        pnlBtnGenerateReport = new javax.swing.JPanel();
        btnTxtGenerateReport = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 244, 236));
        setPreferredSize(new java.awt.Dimension(1096, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("REPORTES VARIOS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        pnlChartReport.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        pnlChartReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlChart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlChartReport.add(pnlChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 650, 360));

        txtTitleChart.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        txtTitleChart.setText("GANANCIA POR SERVICIOS");
        pnlChartReport.add(txtTitleChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        cboSelectChart.setBackground(new java.awt.Color(242, 242, 242));
        cboSelectChart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ganancias por servicios", "Pagos de trabajadores", "Años de experiencia" }));
        cboSelectChart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboSelectChart.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cboSelectChart.setFocusable(false);
        cboSelectChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSelectChartActionPerformed(evt);
            }
        });
        pnlChartReport.add(cboSelectChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 180, 30));

        add(pnlChartReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 700, 460));

        pnlUserReport.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlUserReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("REPORTE DE GANANCIAS POR PRODUCTOS");
        pnlUserReport.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tblWorkerReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblWorkerReport);

        pnlUserReport.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 340, 360));

        add(pnlUserReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 70, 400, 460));

        pnlExportBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        pnlBtnGenerateReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnGenerateReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtGenerateReport.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtGenerateReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtGenerateReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconCheck.png"))); // NOI18N
        btnTxtGenerateReport.setText("EXPORTAR");
        btnTxtGenerateReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtGenerateReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtGenerateReportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtGenerateReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtGenerateReportMouseExited(evt);
            }
        });
        pnlBtnGenerateReport.add(btnTxtGenerateReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        javax.swing.GroupLayout pnlExportBtnLayout = new javax.swing.GroupLayout(pnlExportBtn);
        pnlExportBtn.setLayout(pnlExportBtnLayout);
        pnlExportBtnLayout.setHorizontalGroup(
            pnlExportBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExportBtnLayout.createSequentialGroup()
                .addGap(473, 473, 473)
                .addComponent(pnlBtnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlExportBtnLayout.setVerticalGroup(
            pnlExportBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExportBtnLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnlBtnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        add(pnlExportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 1096, 70));
    }// </editor-fold>//GEN-END:initComponents

    // Estilso del panel
    private void btnTxtGenerateReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtGenerateReportMouseEntered
        pnlBtnGenerateReport.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtGenerateReportMouseEntered

    private void btnTxtGenerateReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtGenerateReportMouseExited
        pnlBtnGenerateReport.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtGenerateReportMouseExited

    private void cboSelectChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSelectChartActionPerformed
        int selectedIndex = cboSelectChart.getSelectedIndex();
            switch (selectedIndex) {
                case 0:
                    mostrarBarChartServicios();
                    txtTitleChart.setText("GANANCIA POR SERVICIOS");
                    break;
                case 1:
                    mostrarPieChart();
                    txtTitleChart.setText("PAGO DE TRABAJADORES");
                    break;
                case 2:
                    mostrarBarChartExperiencia();
                    txtTitleChart.setText("EXPERIENCIA");
                    break;
                default:
                    throw new AssertionError();
            }
    }//GEN-LAST:event_cboSelectChartActionPerformed

    private void btnTxtGenerateReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtGenerateReportMouseClicked
        rep.generarPDF();
    }//GEN-LAST:event_btnTxtGenerateReportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnTxtGenerateReport;
    private javax.swing.JComboBox<String> cboSelectChart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBtnGenerateReport;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JPanel pnlChartReport;
    private javax.swing.JPanel pnlExportBtn;
    private javax.swing.JPanel pnlUserReport;
    private javax.swing.JTable tblWorkerReport;
    private javax.swing.JLabel txtTitleChart;
    // End of variables declaration//GEN-END:variables
}
