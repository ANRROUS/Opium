package Vista;

import Implementación.CliMethod;
import Implementación.EmpMethod;
import Implementación.RecMethod;
import Implementación.SerMethod;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Recibo;
import Modelo.Servicio;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ReciboVista extends javax.swing.JPanel {

    //Objetos con los metodos
    int id_empleado_servicios = 0;
    
    EmpMethod emp = new EmpMethod();
    SerMethod ser = new SerMethod();
    RecMethod rec = new RecMethod();
    CliMethod cli = new CliMethod();

    //Variables
    int id_recibo_actualizar = 0;

    private final DefaultTableModel tblServices = new DefaultTableModel();

    public ReciboVista() {
        initComponents();
        cargarTablaServicios();
        MostrarServicios();
        disenoTablas();
        MostrarTrabajador();
    }

    private void disenoTablas() {
        tblModel.setRowHeight(30);
        tblModel.getTableHeader().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblModel.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
    }

    private void cargarTablaServicios() {
        if (tblServices.getColumnCount() == 0) {
            tblServices.addColumn("ID");
            tblServices.addColumn("Servicio");
            tblServices.addColumn("Productos");
            tblServices.addColumn("Precio");
            tblServices.addColumn("Trabajador");
            tblServices.addColumn("Cliente");
            tblServices.addColumn("Fecha");
            tblModel.setModel(tblServices);
        }
    }

    private void MostrarServicios() {

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
            String fechaRecibo = recibo.getFechaRecibo();
            tblServices.addRow(new Object[]{id_recibo, nombre_servicio, num_pro, monto_servicio, nombre_empleado, nombre_cliente, fechaRecibo});
        }
        ajustarColumnas(tblModel);
    }

    private void MostrarTrabajador() {
        for (Empleado empleado : emp.listarEmpleado()) {
            String nombre_empleado = empleado.getNombreEmpleado();
            cboSelectWorker.addItem(nombre_empleado);
        }
    }

    private void LimpiarDatos() {
        cboSelectService.setSelectedIndex(0);
        cboSelectWorker.setSelectedIndex(0);
        txtSetClienteName.setText("");
        txtSetClienteProducts.setText("");
        txtSetClienteTlf.setText("");
        txtSetPrice.setText("");
        btnTxtAddService.setText("AÑADIR");
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlSectionAddService = new javax.swing.JPanel();
        cboSelectWorker = new javax.swing.JComboBox<>();
        cboSelectService = new javax.swing.JComboBox<>();
        txtSetClienteName = new javax.swing.JTextField();
        txtSetClienteTlf = new javax.swing.JTextField();
        txtSetClienteProducts = new javax.swing.JTextField();
        txtSetPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pnlBtnAddService = new javax.swing.JPanel();
        btnTxtAddService = new javax.swing.JLabel();
        pnlBtnCancel = new javax.swing.JPanel();
        btnTxtCancel = new javax.swing.JLabel();
        pnlContainerTable = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblModel = new javax.swing.JTable();
        pnlBtnDelete = new javax.swing.JPanel();
        btnTxtDelete = new javax.swing.JLabel();
        pnlBtnSaveChanges = new javax.swing.JPanel();
        btnTxtSaveChanges = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 244, 236));
        setPreferredSize(new java.awt.Dimension(1096, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("AÑADIR SERVICIO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        pnlSectionAddService.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        pnlSectionAddService.setPreferredSize(new java.awt.Dimension(440, 530));
        pnlSectionAddService.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboSelectWorker.setBackground(new java.awt.Color(242, 242, 242));
        cboSelectWorker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cboSelectWorker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboSelectWorker.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cboSelectWorker.setFocusable(false);
        cboSelectWorker.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSelectWorkerItemStateChanged(evt);
            }
        });
        cboSelectWorker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboSelectWorkerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboSelectWorkerMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cboSelectWorkerMousePressed(evt);
            }
        });
        pnlSectionAddService.add(cboSelectWorker, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 300, 30));

        cboSelectService.setBackground(new java.awt.Color(242, 242, 242));
        cboSelectService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cboSelectService.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboSelectService.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cboSelectService.setFocusable(false);
        cboSelectService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSelectServiceActionPerformed(evt);
            }
        });
        pnlSectionAddService.add(cboSelectService, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 300, 30));

        txtSetClienteName.setBackground(new java.awt.Color(242, 242, 242));
        txtSetClienteName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetClienteName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddService.add(txtSetClienteName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 300, 30));

        txtSetClienteTlf.setBackground(new java.awt.Color(242, 242, 242));
        txtSetClienteTlf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetClienteTlf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddService.add(txtSetClienteTlf, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 300, 30));

        txtSetClienteProducts.setBackground(new java.awt.Color(242, 242, 242));
        txtSetClienteProducts.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetClienteProducts.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddService.add(txtSetClienteProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 300, 30));

        txtSetPrice.setBackground(new java.awt.Color(242, 242, 242));
        txtSetPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtSetPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSetPriceActionPerformed(evt);
            }
        });
        pnlSectionAddService.add(txtSetPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 300, 30));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("AÑADIR SERVICIO DE TRABAJADOR");
        pnlSectionAddService.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("Seleccionar trabajador:");
        pnlSectionAddService.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Seleccionar servicio:");
        pnlSectionAddService.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Nombre del cliente:");
        pnlSectionAddService.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Teléfono del cliente:");
        pnlSectionAddService.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Productos vendidos:");
        pnlSectionAddService.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel8.setText("Precio del servicio:");
        pnlSectionAddService.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        pnlBtnAddService.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnAddService.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtAddService.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtAddService.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtAddService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconCheck.png"))); // NOI18N
        btnTxtAddService.setText("REGISTRAR");
        btnTxtAddService.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtAddService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtAddServiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtAddServiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtAddServiceMouseExited(evt);
            }
        });
        pnlBtnAddService.add(btnTxtAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        pnlSectionAddService.add(pnlBtnAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 150, 40));

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

        pnlSectionAddService.add(pnlBtnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 150, 40));

        add(pnlSectionAddService, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 440, 530));

        pnlContainerTable.setBackground(new java.awt.Color(252, 244, 228));
        pnlContainerTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlContainerTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel11.setText("HISTORIAL:");
        pnlContainerTable.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

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
        jScrollPane2.setViewportView(tblModel);

        pnlContainerTable.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 610, 420));

        pnlBtnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtDelete.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtDelete.setText("ELIMINAR");
        btnTxtDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtDeleteMouseExited(evt);
            }
        });
        pnlBtnDelete.add(btnTxtDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        pnlContainerTable.add(pnlBtnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, -1));

        pnlBtnSaveChanges.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnSaveChanges.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtSaveChanges.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtSaveChanges.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtSaveChanges.setText("EDITAR");
        btnTxtSaveChanges.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtSaveChanges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtSaveChangesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtSaveChangesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtSaveChangesMouseExited(evt);
            }
        });
        pnlBtnSaveChanges.add(btnTxtSaveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        pnlContainerTable.add(pnlBtnSaveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, -1, -1));

        add(pnlContainerTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 656, 530));
    }// </editor-fold>//GEN-END:initComponents

    // Diseño del panel
    private void btnTxtAddServiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddServiceMouseEntered
        pnlBtnAddService.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtAddServiceMouseEntered

    private void btnTxtAddServiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddServiceMouseExited
        pnlBtnAddService.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtAddServiceMouseExited

    private void btnTxtCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseEntered
        pnlBtnCancel.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtCancelMouseEntered

    private void btnTxtCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseExited
        pnlBtnCancel.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtCancelMouseExited

    private void btnTxtDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDeleteMouseEntered
        pnlBtnDelete.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtDeleteMouseEntered

    private void btnTxtDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDeleteMouseExited
        pnlBtnDelete.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtDeleteMouseExited

    private void btnTxtSaveChangesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveChangesMouseEntered
        pnlBtnSaveChanges.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtSaveChangesMouseEntered

    private void btnTxtSaveChangesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveChangesMouseExited
        pnlBtnSaveChanges.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtSaveChangesMouseExited

    private void cboSelectWorkerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboSelectWorkerMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSelectWorkerMousePressed

    private void cboSelectWorkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboSelectWorkerMouseClicked

    }//GEN-LAST:event_cboSelectWorkerMouseClicked

    private void cboSelectWorkerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSelectWorkerItemStateChanged
        cboSelectService.removeAllItems();
        cboSelectService.addItem("Seleccionar");
        String nombre_empleado = cboSelectWorker.getSelectedItem().toString();
        for (Empleado empleado : emp.listarEmpleado()) {
            String nombre = empleado.getNombreEmpleado();
            if (nombre_empleado.equals(nombre)) {
                id_empleado_servicios = empleado.getIdEmpleado();
                for (Servicio servicio : ser.obtenerServicios(id_empleado_servicios)) {
                    String nombre_servicio = servicio.getNombreServicio();
                    cboSelectService.addItem(nombre_servicio);
                }
            }
        }
    }//GEN-LAST:event_cboSelectWorkerItemStateChanged

    private void btnTxtAddServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddServiceMouseClicked
        String acción = btnTxtAddService.getText();

        Recibo recibo = null;
        Recibo recibo_act = null;

        int id_empleado = 0, id_servicio = 0;
        int id_cliente = 0;
        int id_cliente_registrado = 0;
        String nombre_cliente = txtSetClienteName.getText();
        int numero_cliente = Integer.parseInt(txtSetClienteTlf.getText());
        String nombre_empleado = cboSelectWorker.getSelectedItem().toString();
        int numero_productos = Integer.parseInt(txtSetClienteProducts.getText());
        double monto_total = Double.parseDouble(txtSetPrice.getText());

        for (Empleado empleado : emp.listarEmpleado()) {
            if (empleado.getNombreEmpleado().equals(nombre_empleado)) {
                id_empleado = empleado.getIdEmpleado();
                for (Servicio servicio : ser.obtenerServicios(id_empleado)) {
                    if (servicio.getNombreServicio().equals(cboSelectService.getSelectedItem().toString())) {
                        id_servicio = servicio.getIdServicio();
                    }
                }
            }
        }
        Cliente cliente = new Cliente(0, nombre_cliente, numero_cliente, " ");
        for (Cliente cliente_al : cli.listarCliente()) {
            int num_cliente = cliente_al.getNumeroCliente();
            id_cliente_registrado = cliente_al.getIdCliente();
            if (num_cliente == numero_cliente) {
                id_cliente = cliente_al.getIdCliente();
                recibo = new Recibo(0, id_servicio, numero_productos, monto_total, id_empleado, id_cliente, " ");
                recibo_act = new Recibo(id_recibo_actualizar, id_servicio, numero_productos, monto_total, id_empleado, id_cliente, " ");

            }
        }
        if (id_cliente == 0) {
            id_cliente_registrado++;
            recibo = new Recibo(0, id_servicio, numero_productos, monto_total, id_empleado, id_cliente_registrado, " ");
            recibo_act = new Recibo(id_recibo_actualizar, id_servicio, numero_productos, monto_total, id_empleado, id_cliente_registrado, " ");
            cli.insertar(cliente);
        }
        if (acción.equals("REGISTRAR")) {
            rec.insertar(recibo);
        } else {
            rec.modificar(recibo_act);
        }
        MostrarServicios();
        LimpiarDatos();

    }//GEN-LAST:event_btnTxtAddServiceMouseClicked

    private void btnTxtCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseClicked
        // TODO add your handling code here:
        LimpiarDatos();
        id_recibo_actualizar = 0;
    }//GEN-LAST:event_btnTxtCancelMouseClicked

    private void cboSelectWorkerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboSelectWorkerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSelectWorkerMouseEntered

    private void btnTxtDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDeleteMouseClicked
        // TODO add your handling code here:
        int indice = tblModel.getSelectedRow();
        rec.eliminar((int) tblModel.getValueAt(indice, 0));
        MostrarServicios();
    }//GEN-LAST:event_btnTxtDeleteMouseClicked

    private void btnTxtSaveChangesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveChangesMouseClicked

        int indice = tblModel.getSelectedRow();
        int idRecibo = (int) tblModel.getValueAt(indice, 0);
        id_recibo_actualizar = idRecibo;
        Recibo recibo = rec.obtenerRecibo(idRecibo);
        int idTrabajador = recibo.getIdEmpleado();
        int idServicio = recibo.getIdServicio();
        int idCliente = recibo.getIdCliente();
        int numProductos = recibo.getNumProducto();
        double precioServicio = recibo.getMontoServicio();

        //Presentando los datos en la interfaz
        Empleado empleado = emp.obtenerEmpleado(idTrabajador);
        cboSelectWorker.setSelectedItem(empleado.getNombreEmpleado());
        for (Servicio servicio : ser.obtenerServicios(idTrabajador)) {
            if (idServicio == servicio.getIdServicio()) {
                cboSelectService.setSelectedItem(servicio.getNombreServicio());
            }
        }
        Cliente cliente = cli.obtenerCliente(idCliente);
        txtSetClienteName.setText(cliente.getNombreCliente());
        txtSetClienteTlf.setText(cliente.getNumeroCliente() + "");
        txtSetClienteProducts.setText(numProductos + "");
        txtSetPrice.setText(precioServicio + "");

        btnTxtAddService.setText("ACTUALIZAR");

    }//GEN-LAST:event_btnTxtSaveChangesMouseClicked

    private void txtSetPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSetPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSetPriceActionPerformed

    private void cboSelectServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSelectServiceActionPerformed
        // TODO add your handling code here:
        cboSelectService.addActionListener(e -> {
            String itemSeleccionado = (String) cboSelectService.getSelectedItem();
            if("Seleccionar".equals(itemSeleccionado)){
                txtSetPrice.setText(" ");
            }else{
                for (Servicio servicio : ser.obtenerServicios(id_empleado_servicios)){
                    if(servicio.getNombreServicio().equals(itemSeleccionado)){
                        txtSetPrice.setText(servicio.getPrecioServicio()+"");
                    }
                }
            }
        });
    }//GEN-LAST:event_cboSelectServiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnTxtAddService;
    private javax.swing.JLabel btnTxtCancel;
    private javax.swing.JLabel btnTxtDelete;
    private javax.swing.JLabel btnTxtSaveChanges;
    private javax.swing.JComboBox<String> cboSelectService;
    private javax.swing.JComboBox<String> cboSelectWorker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnlBtnAddService;
    private javax.swing.JPanel pnlBtnCancel;
    private javax.swing.JPanel pnlBtnDelete;
    private javax.swing.JPanel pnlBtnSaveChanges;
    private javax.swing.JPanel pnlContainerTable;
    private javax.swing.JPanel pnlSectionAddService;
    private javax.swing.JTable tblModel;
    private javax.swing.JTextField txtSetClienteName;
    private javax.swing.JTextField txtSetClienteProducts;
    private javax.swing.JTextField txtSetClienteTlf;
    private javax.swing.JTextField txtSetPrice;
    // End of variables declaration//GEN-END:variables
}
