package Vista;

import Implementación.CliMethod;
import Implementación.EmpMethod;
import Implementación.IncMethod;
import Implementación.RecMethod;
import Implementación.SerMethod;
import Modelo.Incidencia;
import Modelo.Recibo;
import Modelo.Servicio;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class IncidenciaVista extends javax.swing.JPanel {

    RecMethod rec = new RecMethod();
    CliMethod cli = new CliMethod();
    EmpMethod emp = new EmpMethod();
    SerMethod ser = new SerMethod();
    IncMethod inc = new IncMethod();

    int id_recibo_act = 0;

    private DefaultTableModel tblServices = new DefaultTableModel();
    private boolean servicesColumns = false;

    private DefaultTableModel tblIncident = new DefaultTableModel();
    private boolean incidentColumns = false;

    private boolean cargaTablas = true;

    public IncidenciaVista() {
        initComponents();
        disabledComponents();
        cargarTablaServicios();
        MostrarServicios();
        disenoTablas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlContainerTable = new javax.swing.JPanel();
        txtTitleHistorial = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblModel = new javax.swing.JTable();
        pnlBtnSaveChanges = new javax.swing.JPanel();
        pnlBtnAutocomplete = new javax.swing.JPanel();
        btnTxtAutoComplete = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        pnlSectionAddIncident = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMinorFault1 = new javax.swing.JLabel();
        txtMinorFault2 = new javax.swing.JLabel();
        txtSeriousFault1 = new javax.swing.JLabel();
        txtSeriousFault2 = new javax.swing.JLabel();
        txtWorker = new javax.swing.JTextField();
        txtClientName = new javax.swing.JTextField();
        cboSelectTypeOfFault = new javax.swing.JComboBox<>();
        txtSetMinorFault = new javax.swing.JTextField();
        txtSetSeriousFault = new javax.swing.JTextField();
        pnlBtnAddIncident = new javax.swing.JPanel();
        btnTxtAddIncident = new javax.swing.JLabel();
        pnlBtnCancel = new javax.swing.JPanel();
        btnTxtCancel = new javax.swing.JLabel();
        pnlBtnChangeTable = new javax.swing.JPanel();
        btnTxtChangeTable = new javax.swing.JLabel();
        txtService = new javax.swing.JTextField();

        setBackground(new java.awt.Color(248, 244, 236));
        setPreferredSize(new java.awt.Dimension(1096, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("REGISTRO DE INCIDENCIAS");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        pnlContainerTable.setBackground(new java.awt.Color(252, 244, 228));
        pnlContainerTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlContainerTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitleHistorial.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        txtTitleHistorial.setText("HISTORIAL DE SERVICIOS:");
        pnlContainerTable.add(txtTitleHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        tblModel.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        tblModel.setModel(new javax.swing.table.DefaultTableModel(
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
        tblModel.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane2.setViewportView(tblModel);

        pnlContainerTable.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 47, 610, 410));

        pnlBtnSaveChanges.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnSaveChanges.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlContainerTable.add(pnlBtnSaveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 480, -1, -1));

        pnlBtnAutocomplete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnAutocomplete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtAutoComplete.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtAutoComplete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtAutoComplete.setText("NUEVA INCIDENCIA");
        btnTxtAutoComplete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtAutoComplete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtAutoCompleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtAutoCompleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtAutoCompleteMouseExited(evt);
            }
        });
        pnlBtnAutocomplete.add(btnTxtAutoComplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        pnlContainerTable.add(pnlBtnAutocomplete, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 160, -1));

        jFormattedTextField1.setText("jFormattedTextField1");
        pnlContainerTable.add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        add(pnlContainerTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 656, 530));

        pnlSectionAddIncident.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        pnlSectionAddIncident.setPreferredSize(new java.awt.Dimension(440, 530));
        pnlSectionAddIncident.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("REGISTRAR INCIDENCIA:");
        pnlSectionAddIncident.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("Seleccionar trabajador:");
        pnlSectionAddIncident.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Servicio:");
        pnlSectionAddIncident.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del cliente:");
        pnlSectionAddIncident.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Selecciona tipo de incidencia:");
        pnlSectionAddIncident.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        txtMinorFault1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtMinorFault1.setText("Incidencia leve:");
        pnlSectionAddIncident.add(txtMinorFault1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        txtMinorFault2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtMinorFault2.setText("Adicional");
        pnlSectionAddIncident.add(txtMinorFault2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        txtSeriousFault1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtSeriousFault1.setText("Incidencia grave:");
        pnlSectionAddIncident.add(txtSeriousFault1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        txtSeriousFault2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        txtSeriousFault2.setText("Descuento al trabajador");
        pnlSectionAddIncident.add(txtSeriousFault2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, -1));

        txtWorker.setBackground(new java.awt.Color(242, 242, 242));
        txtWorker.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtWorker.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddIncident.add(txtWorker, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 300, 30));

        txtClientName.setBackground(new java.awt.Color(242, 242, 242));
        txtClientName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClientName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddIncident.add(txtClientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 300, 30));

        cboSelectTypeOfFault.setBackground(new java.awt.Color(242, 242, 242));
        cboSelectTypeOfFault.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Leve", "Normal", "Grave" }));
        cboSelectTypeOfFault.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboSelectTypeOfFault.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cboSelectTypeOfFault.setFocusable(false);
        cboSelectTypeOfFault.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSelectTypeOfFaultItemStateChanged(evt);
            }
        });
        cboSelectTypeOfFault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSelectTypeOfFaultActionPerformed(evt);
            }
        });
        pnlSectionAddIncident.add(cboSelectTypeOfFault, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 300, 30));

        txtSetMinorFault.setBackground(new java.awt.Color(242, 242, 242));
        txtSetMinorFault.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetMinorFault.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddIncident.add(txtSetMinorFault, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 300, 30));

        txtSetSeriousFault.setBackground(new java.awt.Color(242, 242, 242));
        txtSetSeriousFault.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetSeriousFault.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddIncident.add(txtSetSeriousFault, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 300, 30));

        pnlBtnAddIncident.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnAddIncident.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtAddIncident.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtAddIncident.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtAddIncident.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconCheck.png"))); // NOI18N
        btnTxtAddIncident.setText("REGISTRAR");
        btnTxtAddIncident.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtAddIncident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtAddIncidentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtAddIncidentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtAddIncidentMouseExited(evt);
            }
        });
        pnlBtnAddIncident.add(btnTxtAddIncident, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        pnlSectionAddIncident.add(pnlBtnAddIncident, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 150, 40));

        pnlBtnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnCancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtCancel.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconClear.png"))); // NOI18N
        btnTxtCancel.setText("CANCELAR");
        btnTxtCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtCancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtCancelMouseExited(evt);
            }
        });
        pnlBtnCancel.add(btnTxtCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        pnlSectionAddIncident.add(pnlBtnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 150, 40));

        pnlBtnChangeTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnChangeTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtChangeTable.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtChangeTable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtChangeTable.setText("Ver historial de incidencias");
        btnTxtChangeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtChangeTable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                btnTxtChangeTableComponentRemoved(evt);
            }
        });
        btnTxtChangeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtChangeTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtChangeTableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtChangeTableMouseExited(evt);
            }
        });
        pnlBtnChangeTable.add(btnTxtChangeTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 30));

        pnlSectionAddIncident.add(pnlBtnChangeTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 180, -1));

        txtService.setBackground(new java.awt.Color(242, 242, 242));
        txtService.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtService.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddIncident.add(txtService, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 300, 30));

        add(pnlSectionAddIncident, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 440, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void disabledComponents() {
        txtWorker.setEnabled(false);
        txtClientName.setEnabled(false);
        txtService.setEnabled(false);
        txtMinorFault1.setVisible(false);
        txtMinorFault2.setVisible(false);
        txtSeriousFault1.setVisible(false);
        txtSeriousFault2.setVisible(false);
        txtSetMinorFault.setVisible(false);
        txtSetSeriousFault.setVisible(false);
    }

    private void disenoTablas() {
        tblModel.setRowHeight(30);
        tblModel.getTableHeader().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblModel.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
    }

    private void cargarTablaServicios() {
        clearTable();
        if (!servicesColumns) {
            tblServices.addColumn("ID");
            tblServices.addColumn("Trabajador");
            tblServices.addColumn("Cliente");
            tblServices.addColumn("Servicio");
            tblServices.addColumn("Productos");
            tblServices.addColumn("Precio");
            servicesColumns = true;
        }
        tblModel.setModel(tblServices);
    }

    private void cargarTablaIncidencias() {
        clearTable();
        if (!incidentColumns) {
            tblIncident.addColumn("ID");
            tblIncident.addColumn("Trabajador");
            tblIncident.addColumn("Cliente");
            tblIncident.addColumn("Servicio");
            tblIncident.addColumn("Tipo");
            tblIncident.addColumn("Monto");
            tblIncident.addColumn("Fecha");
            incidentColumns = true;
        }
        tblModel.setModel(tblIncident);
    }

    private void clearTable() {
        tblModel.setModel(new DefaultTableModel());
    }

    public void MostrarServicios() {

        // Falta introducir un filtro el cual ajuste el hecho de que solo muestre servicios que se realizaron en las ultimas 24 horas
        tblServices.setRowCount(0);
        tblServices.setRowCount(0);

        String nombre_servicio = " ";

        for (Recibo recibo : rec.listarRecibo()) {
            int id_recibo = recibo.getIdRecibo();
            int id_servicio = recibo.getIdServicio();
            for (Servicio servicio : ser.ListarServicios()) {
                if (id_servicio == servicio.getIdServicio()) {
                    nombre_servicio = servicio.getNombreServicio();
                }
            }
            int num_pro = recibo.getNumProducto();
            double monto_servicio = recibo.getMontoServicio();
            String nombre_empleado = emp.obtenerEmpleado(recibo.getIdEmpleado()).getNombreEmpleado();
            String nombre_cliente = cli.obtenerCliente(recibo.getIdCliente()).getNombreCliente();

            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String fechaRecibo = recibo.getFechaRecibo();
            LocalDateTime fechaReciboDateTime = LocalDateTime.parse(fechaRecibo, formatter);

            long horasDiferencia = java.time.Duration.between(fechaReciboDateTime, ahora).toHours();
            if (horasDiferencia < 24) {
                tblServices.addRow(new Object[]{id_recibo, nombre_empleado, nombre_cliente, nombre_servicio, num_pro, monto_servicio});

            }
        }
        ajustarColumnas(tblModel);

    }

    // Método para ajustar automáticamente el ancho de las columnas de la tabla
    private void ajustarColumnas(JTable table) {
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            ajustarAnchoColumna(table, i);
        }
    }

    private void ajustarAnchoColumna(JTable table, int colIndex) {
        int anchoMaximo = 0;
        TableColumn columna = table.getColumnModel().getColumn(colIndex);
        for (int fila = 0; fila < table.getRowCount(); fila++) {
            TableCellRenderer renderer = table.getCellRenderer(fila, colIndex);
            Component comp = table.prepareRenderer(renderer, fila, colIndex);
            anchoMaximo = Math.max(comp.getPreferredSize().width, anchoMaximo);
        }
        columna.setPreferredWidth(anchoMaximo + 10);
    }

    public void MostrarIncidencias() {

        tblIncident.setRowCount(0);

        for (Incidencia incidencia : inc.listarIncidencia()) {
            int idRecibo = incidencia.getIdRecibo();
            int idIncidencia = incidencia.getIdIncidencia();
            Recibo recibo = rec.obtenerRecibo(idRecibo);
            int id_servicio = recibo.getIdServicio();
            String nombre_servicio = " ";
            for (Servicio servicio : ser.ListarServicios()) {
                if (id_servicio == servicio.getIdServicio()) {
                    nombre_servicio = servicio.getNombreServicio();
                }
            }
            String nombreEmpleado = emp.obtenerEmpleado(recibo.getIdEmpleado()).getNombreEmpleado();
            String nombreCliente = cli.obtenerCliente(recibo.getIdCliente()).getNombreCliente();
            String fechaIncidencia = incidencia.getFechaIncidencia();
            String tipoIncidencia = incidencia.getTipoIncidencia();
            double montoAdicional = incidencia.getMontoAdicional();
            double montoDescuento = incidencia.getMontoDescuento();
            String monto = " ";
            switch (tipoIncidencia) {
                case "Leve":
                    monto = "+" + montoAdicional;
                    break;
                case "Normal":
                    monto = "0.00";
                    break;
                case "Grave":
                    monto = "-" + montoDescuento;
                    break;
            }
            tblIncident.addRow(new Object[]{idIncidencia, nombreEmpleado, nombreCliente, nombre_servicio, tipoIncidencia, monto, fechaIncidencia});
        }
        ajustarColumnas(tblModel);
    }

    private void LimpiarTodo() {
        txtClientName.setText("");
        txtSetMinorFault.setText("");
        txtSetSeriousFault.setText("");
        txtService.setText("");
        txtWorker.setText("");
        cboSelectTypeOfFault.setSelectedIndex(0);
        btnTxtAutoComplete.setEnabled(true);
    }

    private void btnTxtAddIncidentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddIncidentMouseEntered
        pnlBtnAddIncident.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtAddIncidentMouseEntered

    private void btnTxtAddIncidentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddIncidentMouseExited
        pnlBtnAddIncident.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtAddIncidentMouseExited

    private void btnTxtCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseEntered
        pnlBtnCancel.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtCancelMouseEntered

    private void btnTxtCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseExited
        pnlBtnCancel.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtCancelMouseExited

    private void cboSelectTypeOfFaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSelectTypeOfFaultActionPerformed

    }//GEN-LAST:event_cboSelectTypeOfFaultActionPerformed

    private void btnTxtChangeTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtChangeTableMouseEntered
        pnlBtnChangeTable.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtChangeTableMouseEntered

    private void btnTxtChangeTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtChangeTableMouseExited
        pnlBtnChangeTable.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtChangeTableMouseExited

    private void btnTxtChangeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtChangeTableMouseClicked
        if (cargaTablas && btnTxtChangeTable.getText().equals("Ver historial de incidencias")) {
            cargarTablaIncidencias();
            MostrarIncidencias();
            btnTxtChangeTable.setText("Ver historial de servicios");
            txtTitleHistorial.setText("HISTORIAL DE INCIDENCIAS");
            btnTxtAutoComplete.setText("ELIMINAR");
        } else {
            cargarTablaServicios();
            MostrarServicios();
            btnTxtChangeTable.setText("Ver historial de incidencias");
            txtTitleHistorial.setText("HISTORIAL DE SERVICIOS");
            btnTxtAutoComplete.setText("NUEVA INCIDENCIA");
        }
        cargaTablas = !cargaTablas;
    }//GEN-LAST:event_btnTxtChangeTableMouseClicked

    private void btnTxtAutoCompleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAutoCompleteMouseExited
        pnlBtnAutocomplete.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtAutoCompleteMouseExited

    private void btnTxtAutoCompleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAutoCompleteMouseEntered
        pnlBtnAutocomplete.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtAutoCompleteMouseEntered

    private void cboSelectTypeOfFaultItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSelectTypeOfFaultItemStateChanged
        String selectedIndex = cboSelectTypeOfFault.getSelectedItem().toString();
        switch (selectedIndex) {
            case "Leve":
                txtMinorFault1.setVisible(true);
                txtMinorFault2.setVisible(true);
                txtSeriousFault1.setVisible(false);
                txtSeriousFault2.setVisible(false);
                txtSetMinorFault.setVisible(true);
                txtSetSeriousFault.setVisible(false);
                break;
            case "Grave":
                txtMinorFault1.setVisible(false);
                txtMinorFault2.setVisible(false);
                txtSeriousFault1.setVisible(true);
                txtSeriousFault2.setVisible(true);
                txtSetMinorFault.setVisible(false);
                txtSetSeriousFault.setVisible(true);
                break;
            case "Normal":
                txtMinorFault1.setVisible(false);
                txtMinorFault2.setVisible(false);
                txtSeriousFault1.setVisible(false);
                txtSeriousFault2.setVisible(false);
                txtSetMinorFault.setVisible(false);
                txtSetSeriousFault.setVisible(false);
                break;
        }
    }//GEN-LAST:event_cboSelectTypeOfFaultItemStateChanged

    private void btnTxtAutoCompleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAutoCompleteMouseClicked
        // TODO add your handling code here:
        String estadoBoton = btnTxtAutoComplete.getText();
        int indice = tblModel.getSelectedRow();
        if (estadoBoton.equals("ELIMINAR")) {
            int id_incidencia = (int) tblIncident.getValueAt(indice, 0);
            inc.eliminar(id_incidencia);
            MostrarIncidencias();
        } else {
            btnTxtAutoComplete.setEnabled(false);
            id_recibo_act = (int) tblServices.getValueAt(indice, 0);
            txtWorker.setText(tblServices.getValueAt(indice, 1).toString());
            txtService.setText(tblServices.getValueAt(indice, 3).toString());
            txtClientName.setText(tblServices.getValueAt(indice, 2).toString());
        }

    }//GEN-LAST:event_btnTxtAutoCompleteMouseClicked

    private void btnTxtAddIncidentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddIncidentMouseClicked
        // TODO add your handling code here:
        String tipoIncidencia = cboSelectTypeOfFault.getSelectedItem().toString();
        double montoAdicional = 0, montoDescuento = 0;
        switch (tipoIncidencia) {
            case "Leve":
                montoAdicional = Double.parseDouble(txtSetMinorFault.getText());
                montoDescuento = 0;
                break;
            case "Normal":
                montoAdicional = montoDescuento = 0;
                break;
            case "Grave":
                montoDescuento = Double.parseDouble(txtSetSeriousFault.getText());
                break;
        }
        Incidencia newIncidencia = new Incidencia(0, id_recibo_act, tipoIncidencia, montoAdicional, montoDescuento, " ");
        inc.insertar(newIncidencia);

        MostrarIncidencias();
        LimpiarTodo();

    }//GEN-LAST:event_btnTxtAddIncidentMouseClicked

    private void btnTxtChangeTableComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_btnTxtChangeTableComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTxtChangeTableComponentRemoved

    private void btnTxtCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseClicked
        // TODO add your handling code here:
        LimpiarTodo();
    }//GEN-LAST:event_btnTxtCancelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnTxtAddIncident;
    private javax.swing.JLabel btnTxtAutoComplete;
    private javax.swing.JLabel btnTxtCancel;
    private javax.swing.JLabel btnTxtChangeTable;
    private javax.swing.JComboBox<String> cboSelectTypeOfFault;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlBtnAddIncident;
    private javax.swing.JPanel pnlBtnAutocomplete;
    private javax.swing.JPanel pnlBtnCancel;
    private javax.swing.JPanel pnlBtnChangeTable;
    private javax.swing.JPanel pnlBtnSaveChanges;
    private javax.swing.JPanel pnlContainerTable;
    private javax.swing.JPanel pnlSectionAddIncident;
    private javax.swing.JTable tblModel;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JLabel txtMinorFault1;
    private javax.swing.JLabel txtMinorFault2;
    private javax.swing.JLabel txtSeriousFault1;
    private javax.swing.JLabel txtSeriousFault2;
    private javax.swing.JTextField txtService;
    private javax.swing.JTextField txtSetMinorFault;
    private javax.swing.JTextField txtSetSeriousFault;
    private javax.swing.JLabel txtTitleHistorial;
    private javax.swing.JTextField txtWorker;
    // End of variables declaration//GEN-END:variables
}
