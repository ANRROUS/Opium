package Vista;

import Implementación.AdminMethod;
import Implementación.CliMethod;
import Implementación.EmpMethod;
import Implementación.SerMethod;
import Modelo.Administrador;
import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.Servicio;
import SQL_Conection.SQL_Conexion;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UsuariosVista extends javax.swing.JPanel {

    SerMethod ser = new SerMethod();
    CliMethod cli = new CliMethod();
    EmpMethod emp = new EmpMethod();
    AdminMethod admin = new AdminMethod();

    //Arreglos
    String[] Credenciales = new String[2];
    String[] Credenciales2 = new String[2];

    //Variables
    int id_empleado_actualizar;
    int id_administrador_actualizar;

    private DefaultTableModel tblCliente = new DefaultTableModel();
    private boolean clienteColumns = false;

    private DefaultTableModel tblAdministrador = new DefaultTableModel();

    private DefaultTableModel tblTrabajador = new DefaultTableModel();
    private boolean trabajadorColumns = false;

    private DefaultTableModel tblCargaUserService = new DefaultTableModel();
    private DefaultTableModel tblCargaServices = new DefaultTableModel();

    public UsuariosVista() {
        initComponents();
        cargarTablaCliente();
        cargaTablaServiciosUsuarios();
        cargarTablaServicios();
        MostrarServicios();
        MostrarUsuariosRegistrados();
        disenoTablas();
        //Algunos botones ocultos
        btnTxtEdit.setVisible(false);
        pnlBtnEdit.setVisible(false);

        txtNewBonoSemanal.setVisible(false);
        jLabel7.setVisible(false);
        rbtnTrabajador.setSelected(true);

        btnTxtAddWorker16.setVisible(false);
        pnlBtnAddWorker16.setVisible(false);

        btnTxtDelete1.setVisible(false);
        pnlBtnDelete1.setVisible(false);

        tblCargaUserService.setRowCount(0);
    }

    private void disenoTablas() {
        tblModel.setRowHeight(30);
        tblModel.getTableHeader().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblModel.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));

        tblUserService.setRowHeight(30);
        tblUserService.getTableHeader().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblUserService.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));

        tblService.setRowHeight(30);
        tblService.getTableHeader().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblService.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
    }

    private void cargarTablaCliente() {
        clearTable();
        if (!clienteColumns) {
            tblCliente.addColumn("ID");
            tblCliente.addColumn("Nombre");
            tblCliente.addColumn("Teléfono");
            tblCliente.addColumn("Rol");
            clienteColumns = true;
        }
        tblModel.setModel(tblCliente);
    }

    private void cargarTablaTrabajador() {
        clearTable();
        if (!trabajadorColumns) {
            tblTrabajador.addColumn("ID");
            tblTrabajador.addColumn("Nombre");
            tblTrabajador.addColumn("Telefono");
            tblTrabajador.addColumn("Experiencia");
            tblTrabajador.addColumn("Comision");
            trabajadorColumns = true;
        }
        tblModel.setModel(tblTrabajador);
    }

    //Tabla servicios del nuevo trabajador registrado
    private void cargaTablaServiciosUsuarios() {
        if (tblCargaUserService.getColumnCount() == 0) {
            tblCargaUserService.addColumn("Nombre del Servicio");
            tblCargaUserService.addColumn("Precio del Servicio");
            tblUserService.setModel(tblCargaUserService);
        }
    }

    //Tabla de todos los servicios registrados en la base de datos
    private void cargarTablaServicios() {
        if (tblCargaServices.getColumnCount() == 0) {
            tblCargaServices.addColumn("ID");
            tblCargaServices.addColumn("Nombre");
            tblCargaServices.addColumn("Precio");
            tblService.setModel(tblCargaServices);
        }
    }

    //Mostrar todos lo servicios
    private void MostrarServicios() {
        tblCargaServices.setRowCount(0);
        for (Servicio servicio : ser.ListarServicios()) {
            int idServicio = servicio.getIdServicio();
            String nombreServicio = servicio.getNombreServicio();
            double precioServicio = servicio.getPrecioServicio();
            tblCargaServices.addRow(new Object[]{idServicio, nombreServicio, precioServicio});
        }
    }

    //Metodo para mostrar en la tabla los Usuarios Registrados
    private void MostrarUsuariosRegistrados() {
        tblCliente.setRowCount(0);
        for (Empleado empleado : emp.listarEmpleado()) {
            int idEmpleado = empleado.getIdEmpleado();
            String nombreEmpleado = empleado.getNombreEmpleado();
            int telefonoEmpleado = empleado.getTelefonoEmpleado();
            String rol = empleado.getRolEmpleado();
            if (rol.equals("Trabajador")) {
                tblCliente.addRow(new Object[]{idEmpleado, nombreEmpleado, telefonoEmpleado, rol});
            }
        }
        for (Cliente cliente : cli.listarCliente()) {
            int idCliente = cliente.getIdCliente();
            String nombreCliente = cliente.getNombreCliente();
            int telefonoCliente = cliente.getNumeroCliente();
            String rol = "Cliente";
            tblCliente.addRow(new Object[]{idCliente, nombreCliente, telefonoCliente, rol});
        }
        for (Administrador administrador : admin.listarAdministrador()) {
            int idAdministrador = administrador.getIdAdministrador();
            String nombreAdministrdor = administrador.getNombreEmpleado();
            int telefonoAdministrador = administrador.getTelefonoEmpleado();
            String rol = administrador.getRolEmpleado();
            tblCliente.addRow(new Object[]{idAdministrador, nombreAdministrdor, telefonoAdministrador, rol});
        }
    }

    private void MostrarClientes() {
        tblCliente.setRowCount(0);
        for (Cliente cliente : cli.listarCliente()) {
            int idCliente = cliente.getIdCliente();
            String nombreCliente = cliente.getNombreCliente();
            int telefonoCliente = cliente.getNumeroCliente();
            String rol = "Cliente";
            tblCliente.addRow(new Object[]{idCliente, nombreCliente, telefonoCliente, rol});
        }
    }

    //Mostrar usuarios por rango
    private void MostrarUsuariosRol(String rol) {
        tblTrabajador.setRowCount(0);
        if ("Trabajador".equals(rol)) {
            for (Empleado empleado : emp.listarEmpleado()) {
                int idEmpleado = empleado.getIdEmpleado();
                String nombreEmpleado = empleado.getNombreEmpleado();
                int telefonoEmpleado = empleado.getTelefonoEmpleado();
                int añosExperiencia = empleado.getAñosExperiencia();
                double comision = empleado.getPorcentajeComision();
                if ("Trabajador".equals(empleado.getRolEmpleado())) {
                    tblTrabajador.addRow(new Object[]{idEmpleado, nombreEmpleado, telefonoEmpleado, añosExperiencia, comision});
                }
            }
        } else {
            for (Administrador administrador : admin.listarAdministrador()) {
                int idAdministrador = administrador.getIdAdministrador();
                String nombreAdministrdor = administrador.getNombreEmpleado();
                int telefonoAdministrador = administrador.getTelefonoEmpleado();
                int añosExperiencia = administrador.getAñosExperiencia();
                double comision = administrador.getPorcentajeComision();
                tblTrabajador.addRow(new Object[]{idAdministrador, nombreAdministrdor, telefonoAdministrador, añosExperiencia, comision});
            }
        }
    }

    private void clearTable() {
        tblModel.setModel(new DefaultTableModel());
    }

    private void LimpiarTodo() {
        txtSetNewComision1.setText("");
        txtSetNewExperience.setText("");
        txtSetNewLName.setText("");
        txtSetNewName.setText("");
        txtSetNewNameService1.setText("");
        txtSetNewPriceService.setText("");
        txtSetNewTlf.setText("");
        txtNewBonoSemanal.setText("");
        btnTxtAddWorker16.setVisible(false);
        pnlBtnAddWorker16.setVisible(false);
        jLabel8.setVisible(true);
        rbtnAdministrador.setVisible(true);
        rbtnTrabajador.setVisible(true);
        jLabel7.setVisible(false);
        txtNewBonoSemanal.setVisible(false);
        tbdPn.setEnabled(true);
        btnTxtEdit.setEnabled(true);
        btnTxtAddWorker.setText("AÑADIR");
        tblCargaUserService.setRowCount(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupAdmin = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlSectionAddWorker = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSetNewName = new javax.swing.JTextField();
        txtSetNewLName = new javax.swing.JTextField();
        txtSetNewTlf = new javax.swing.JTextField();
        txtSetNewExperience = new javax.swing.JTextField();
        txtNewBonoSemanal = new javax.swing.JTextField();
        pnlBtnAddWorker = new javax.swing.JPanel();
        btnTxtAddWorker = new javax.swing.JLabel();
        pnlBtnCancel = new javax.swing.JPanel();
        btnTxtCancel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rbtnAdministrador = new javax.swing.JRadioButton();
        rbtnTrabajador = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtSetNewComision1 = new javax.swing.JTextField();
        pnlBtnAddWorker16 = new javax.swing.JPanel();
        btnTxtAddWorker16 = new javax.swing.JLabel();
        tbdPn = new javax.swing.JTabbedPane();
        pnlUserAddService = new javax.swing.JPanel();
        pnlContainer2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSetNewNameService1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSetNewPriceService = new javax.swing.JTextField();
        pnlBtnDelete2 = new javax.swing.JPanel();
        btnTxtDelete2 = new javax.swing.JLabel();
        pnlBtnSaveChanges2 = new javax.swing.JPanel();
        btnTxtSaveChanges2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblService = new javax.swing.JTable();
        adsf = new javax.swing.JScrollPane();
        tblUserService = new javax.swing.JTable();
        pnlUserHistorial = new javax.swing.JPanel();
        pnlContainer1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cboSelectTypeOf = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblModel = new javax.swing.JTable();
        pnlBtnDelete1 = new javax.swing.JPanel();
        btnTxtDelete1 = new javax.swing.JLabel();
        pnlBtnSaveChanges1 = new javax.swing.JPanel();
        pnlBtnEdit = new javax.swing.JPanel();
        btnTxtEdit = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 244, 236));
        setPreferredSize(new java.awt.Dimension(1096, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSectionAddWorker.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        pnlSectionAddWorker.setPreferredSize(new java.awt.Dimension(440, 530));
        pnlSectionAddWorker.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("Ingresar nombre del trabajador:");
        pnlSectionAddWorker.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Ingresar apellido del trabajador:");
        pnlSectionAddWorker.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Teléfono del trabajador:");
        pnlSectionAddWorker.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Años de experiencia:");
        pnlSectionAddWorker.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Bono Semanal:");
        pnlSectionAddWorker.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        txtSetNewName.setBackground(new java.awt.Color(242, 242, 242));
        txtSetNewName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetNewName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddWorker.add(txtSetNewName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 310, 30));

        txtSetNewLName.setBackground(new java.awt.Color(242, 242, 242));
        txtSetNewLName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetNewLName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddWorker.add(txtSetNewLName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 310, 30));

        txtSetNewTlf.setBackground(new java.awt.Color(242, 242, 242));
        txtSetNewTlf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetNewTlf.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddWorker.add(txtSetNewTlf, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 310, 30));

        txtSetNewExperience.setBackground(new java.awt.Color(242, 242, 242));
        txtSetNewExperience.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetNewExperience.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddWorker.add(txtSetNewExperience, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 310, 30));

        txtNewBonoSemanal.setBackground(new java.awt.Color(242, 242, 242));
        txtNewBonoSemanal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNewBonoSemanal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtNewBonoSemanal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNewBonoSemanalActionPerformed(evt);
            }
        });
        pnlSectionAddWorker.add(txtNewBonoSemanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 120, 30));

        pnlBtnAddWorker.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnAddWorker.setPreferredSize(new java.awt.Dimension(150, 40));
        pnlBtnAddWorker.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtAddWorker.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtAddWorker.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtAddWorker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconCheck.png"))); // NOI18N
        btnTxtAddWorker.setText("AÑADIR");
        btnTxtAddWorker.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtAddWorker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtAddWorkerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtAddWorkerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtAddWorkerMouseExited(evt);
            }
        });
        pnlBtnAddWorker.add(btnTxtAddWorker, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        pnlSectionAddWorker.add(pnlBtnAddWorker, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 150, 40));

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

        pnlSectionAddWorker.add(pnlBtnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 150, 40));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("REGISTRAR TRABAJADOR");
        pnlSectionAddWorker.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel16.setText("Comisión:");
        pnlSectionAddWorker.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        btnGroupAdmin.add(rbtnAdministrador);
        rbtnAdministrador.setText("Si");
        rbtnAdministrador.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtnAdministradorStateChanged(evt);
            }
        });
        rbtnAdministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnAdministradorMouseClicked(evt);
            }
        });
        pnlSectionAddWorker.add(rbtnAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        btnGroupAdmin.add(rbtnTrabajador);
        rbtnTrabajador.setText("No");
        pnlSectionAddWorker.add(rbtnTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel8.setText("Administrador:");
        pnlSectionAddWorker.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, -1));

        txtSetNewComision1.setBackground(new java.awt.Color(242, 242, 242));
        txtSetNewComision1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetNewComision1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlSectionAddWorker.add(txtSetNewComision1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 100, 30));

        pnlBtnAddWorker16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnAddWorker16.setPreferredSize(new java.awt.Dimension(150, 40));
        pnlBtnAddWorker16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtAddWorker16.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtAddWorker16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtAddWorker16.setText("CREDENCIALES");
        btnTxtAddWorker16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtAddWorker16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtAddWorker16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtAddWorker16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtAddWorker16MouseExited(evt);
            }
        });
        pnlBtnAddWorker16.add(btnTxtAddWorker16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        pnlSectionAddWorker.add(pnlBtnAddWorker16, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 150, 40));

        add(pnlSectionAddWorker, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 440, 530));

        tbdPn.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbdPn.setPreferredSize(new java.awt.Dimension(656, 530));
        tbdPn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdPnMouseClicked(evt);
            }
        });

        pnlUserAddService.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContainer2.setBackground(new java.awt.Color(248, 244, 236));
        pnlContainer2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel11.setText("AGREGAR SERVICIO DEL TRABAJADOR:");
        pnlContainer2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel13.setText("Servicios existentes:");
        pnlContainer2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        txtSetNewNameService1.setBackground(new java.awt.Color(242, 242, 242));
        txtSetNewNameService1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetNewNameService1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlContainer2.add(txtSetNewNameService1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 310, 30));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel2.setText(" Ingresar el precio del servicio nuevo o existente:");
        pnlContainer2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtSetNewPriceService.setBackground(new java.awt.Color(242, 242, 242));
        txtSetNewPriceService.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetNewPriceService.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlContainer2.add(txtSetNewPriceService, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 310, 30));

        pnlBtnDelete2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnDelete2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtDelete2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtDelete2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtDelete2.setText("ELIMINAR");
        btnTxtDelete2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtDelete2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtDelete2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtDelete2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtDelete2MouseExited(evt);
            }
        });
        pnlBtnDelete2.add(btnTxtDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        pnlContainer2.add(pnlBtnDelete2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        pnlBtnSaveChanges2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnSaveChanges2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtSaveChanges2.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtSaveChanges2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtSaveChanges2.setText("REGISTRAR");
        btnTxtSaveChanges2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtSaveChanges2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtSaveChanges2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtSaveChanges2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtSaveChanges2MouseExited(evt);
            }
        });
        pnlBtnSaveChanges2.add(btnTxtSaveChanges2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        pnlContainer2.add(pnlBtnSaveChanges2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel14.setText("Ingresar el nombre del servicio nuevo o existente:");
        pnlContainer2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        tblService.setModel(new javax.swing.table.DefaultTableModel(
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
        tblService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServiceMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblService);

        pnlContainer2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 280, 460));

        tblUserService.setModel(new javax.swing.table.DefaultTableModel(
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
        adsf.setViewportView(tblUserService);

        pnlContainer2.add(adsf, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 247, 310, 240));

        pnlUserAddService.add(pnlContainer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 500));

        tbdPn.addTab("Añadir servicio al trabajador", pnlUserAddService);

        pnlUserHistorial.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlContainer1.setBackground(new java.awt.Color(252, 244, 228));
        pnlContainer1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlContainer1.setPreferredSize(new java.awt.Dimension(656, 530));
        pnlContainer1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel9.setText("HISTORIAL:");
        pnlContainer1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel12.setText("Buscar por:");
        pnlContainer1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        cboSelectTypeOf.setBackground(new java.awt.Color(242, 242, 242));
        cboSelectTypeOf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Cliente", "Trabajador", "Administrador" }));
        cboSelectTypeOf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboSelectTypeOf.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cboSelectTypeOf.setFocusable(false);
        cboSelectTypeOf.setPreferredSize(new java.awt.Dimension(140, 30));
        cboSelectTypeOf.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSelectTypeOfItemStateChanged(evt);
            }
        });
        cboSelectTypeOf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboSelectTypeOfMouseClicked(evt);
            }
        });
        cboSelectTypeOf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSelectTypeOfActionPerformed(evt);
            }
        });
        pnlContainer1.add(cboSelectTypeOf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

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
        jScrollPane1.setViewportView(tblModel);

        pnlContainer1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 640, 400));

        pnlBtnDelete1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnDelete1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtDelete1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtDelete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtDelete1.setText("ELIMINAR");
        btnTxtDelete1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtDelete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtDelete1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtDelete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtDelete1MouseExited(evt);
            }
        });
        pnlBtnDelete1.add(btnTxtDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        pnlContainer1.add(pnlBtnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, -1, -1));

        pnlBtnSaveChanges1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnSaveChanges1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlContainer1.add(pnlBtnSaveChanges1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, -1, -1));

        pnlBtnEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtEdit.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtEdit.setText("EDITAR");
        btnTxtEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtEditMouseExited(evt);
            }
        });
        pnlBtnEdit.add(btnTxtEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        pnlContainer1.add(pnlBtnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        pnlUserHistorial.add(pnlContainer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        tbdPn.addTab("Usuarios registrados", pnlUserHistorial);

        add(tbdPn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 656, 530));

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel15.setText("REGISTRAR Y ADMINISTRAR USUARIOS");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    // Diseño del panel
    private void btnTxtAddWorkerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddWorkerMouseEntered
        pnlBtnAddWorker.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtAddWorkerMouseEntered

    private void btnTxtAddWorkerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddWorkerMouseExited
        pnlBtnAddWorker.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtAddWorkerMouseExited

    private void btnTxtCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseEntered
        pnlBtnCancel.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtCancelMouseEntered

    private void btnTxtCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseExited
        pnlBtnCancel.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtCancelMouseExited

    private void btnTxtDelete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDelete1MouseEntered
        pnlBtnDelete1.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtDelete1MouseEntered

    private void btnTxtDelete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDelete1MouseExited
        pnlBtnDelete1.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtDelete1MouseExited

    private void btnTxtEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtEditMouseEntered
        pnlBtnEdit.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtEditMouseEntered

    private void btnTxtEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtEditMouseExited
        pnlBtnEdit.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtEditMouseExited

    private void btnTxtDelete2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDelete2MouseEntered
        pnlBtnDelete2.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtDelete2MouseEntered

    private void btnTxtDelete2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDelete2MouseExited
        pnlBtnDelete2.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtDelete2MouseExited

    private void btnTxtSaveChanges2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveChanges2MouseEntered
        pnlBtnSaveChanges2.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtSaveChanges2MouseEntered

    private void btnTxtSaveChanges2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveChanges2MouseExited
        pnlBtnSaveChanges2.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtSaveChanges2MouseExited

    private void btnTxtSaveChanges2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveChanges2MouseClicked
        // TODO add your handling code here:
        try {
            String name_new_service = txtSetNewNameService1.getText();
            double price_new_service = Double.parseDouble(txtSetNewPriceService.getText());
            tblCargaUserService.addRow(new Object[]{name_new_service, price_new_service});
            txtSetNewNameService1.setText("");
            txtSetNewPriceService.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos ingresados");
        }
    }//GEN-LAST:event_btnTxtSaveChanges2MouseClicked

    private void tblServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiceMouseClicked
        int number_row = tblService.getSelectedRow();
        String name_new_service = tblCargaServices.getValueAt(number_row, 1).toString();
        double price_new_service = Double.parseDouble(tblCargaServices.getValueAt(number_row, 2).toString());
        txtSetNewNameService1.setText(name_new_service);
        txtSetNewPriceService.setText(price_new_service + "");
    }//GEN-LAST:event_tblServiceMouseClicked

    private void tbdPnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdPnMouseClicked

    }//GEN-LAST:event_tbdPnMouseClicked

    private void btnTxtDelete2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDelete2MouseClicked
        // TODO add your handling code here:
        try {
            int indice = tblUserService.getSelectedRow();
            tblCargaUserService.removeRow(indice);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnTxtDelete2MouseClicked

    private void rbtnAdministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnAdministradorMouseClicked

        // Verificar si el botón de administrador está seleccionado
        if (rbtnAdministrador.isSelected()) {
            // Crear un panel para los campos de entrada
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            // Crear los campos de entrada
            JTextField campoUsuario = new JTextField(15);
            JPasswordField campoContrasena = new JPasswordField(15);
            JPasswordField campoConfirmarContrasena = new JPasswordField(15);

            // Añadir etiquetas y campos al panel
            panel.add(new JLabel("Usuario:"));
            panel.add(campoUsuario);
            panel.add(new JLabel("Contraseña:"));
            panel.add(campoContrasena);
            panel.add(new JLabel("Confirmar Contraseña:"));
            panel.add(campoConfirmarContrasena);

            // Mostrar el cuadro de diálogo de entrada
            int resultado = JOptionPane.showConfirmDialog(null, panel, "Registro de Usuario",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            //Verificar si solo se canceló
            if (resultado == JOptionPane.CANCEL_OPTION) {
                rbtnTrabajador.setSelected(true);
            }
            // Verificar el resultado de la selección
            if (resultado == JOptionPane.OK_OPTION) {
                String usuario = campoUsuario.getText().trim();
                String contrasena = new String(campoContrasena.getPassword());
                String confirmarContrasena = new String(campoConfirmarContrasena.getPassword());

                // Verificar si los campos están llenos
                if (usuario.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Credenciales en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    rbtnTrabajador.setSelected(true);
                    return;
                }

                // Verificar si las contraseñas coinciden
                if (contrasena.equals(confirmarContrasena)) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso!\nUsuario: " + usuario);
                    Credenciales[0] = usuario;
                    Credenciales[1] = contrasena;
                    txtNewBonoSemanal.setVisible(true);
                    jLabel7.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                    rbtnTrabajador.setSelected(true);
                }
            }
        }
        if (rbtnTrabajador.isSelected()) {
            // Limpiar las credenciales si se selecciona el trabajador
            Credenciales[0] = null;
            Credenciales[1] = null;
        }

    }//GEN-LAST:event_rbtnAdministradorMouseClicked

    private void rbtnAdministradorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtnAdministradorStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnAdministradorStateChanged

    private void btnTxtAddWorkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddWorkerMouseClicked
        String estado = btnTxtAddWorker.getText();
        int id = 0;
        double bono_semanal = 0.00;
        String name_worker = txtSetNewName.getText();
        String last_name_worker = txtSetNewLName.getText();
        String nombre = name_worker + ' ' + last_name_worker;
        int number_worker = Integer.parseInt(txtSetNewTlf.getText());
        int experiencia = Integer.parseInt(txtSetNewExperience.getText());
        double comision = Double.parseDouble(txtSetNewComision1.getText());
        if ("AÑADIR".equals(estado)) {
            try {
                if (rbtnAdministrador.isSelected()) {
                    bono_semanal = Double.parseDouble(txtNewBonoSemanal.getText());
                    Empleado new_empleado = new Empleado(id, nombre, number_worker, experiencia, comision, " ", "Administrador");
                    emp.insertar(new_empleado);
                } else if (rbtnTrabajador.isSelected()) {
                    Empleado new_empleado = new Empleado(id, nombre, number_worker, experiencia, comision, " ", "Trabajador");
                    emp.insertar(new_empleado);
                }

                try {
                    String consulta = "Select max(idEmpleado) as ultimo_id from empleado";
                    Connection conexion = SQL_Conexion.conectar();
                    PreparedStatement state = conexion.prepareStatement(consulta);
                    ResultSet resultado = state.executeQuery();

                    if (resultado.next()) {
                        id = resultado.getInt("ultimo_id");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No hay trabajadores registrados aún");
                }

                for (int i = 0; i < tblCargaUserService.getRowCount(); i++) {
                    int id_servicio = 0;
                    String name_new_service = tblCargaUserService.getValueAt(i, 0).toString();
                    double price_new_service = Double.parseDouble(tblCargaUserService.getValueAt(i, 1).toString());
                    Servicio new_servicio = new Servicio(id_servicio, name_new_service, price_new_service, id);
                    ser.insertar(new_servicio);
                }

                if (rbtnAdministrador.isSelected()) {
                    int id_admin = 0;
                    String usuario = Credenciales[0];
                    String contraseña = Credenciales[1];
                    Administrador new_admin = new Administrador(id, nombre, number_worker, experiencia, comision, " ", "Administrador", id_admin, bono_semanal, usuario, contraseña);
                    admin.insertar(new_admin);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos");
            }
        } else {
            //Si esto está visible, es que se está actualizando un administrador
            if (btnTxtAddWorker16.isVisible()) {
                bono_semanal = Double.parseDouble(txtNewBonoSemanal.getText());
                Administrador new_admin = new Administrador(id_empleado_actualizar, nombre, number_worker, experiencia, comision, " ", "Administrador", id_administrador_actualizar, bono_semanal, Credenciales2[0], Credenciales2[1]);
                admin.actualizar(new_admin);
                emp.actualizar(new_admin);
                ser.eliminar(id_empleado_actualizar);
            } else {
                //En caso de que el trabajador queda registrado con sus credenciales
                if (rbtnAdministrador.isSelected()) {
                    String usuario = Credenciales[0];
                    String contraseña = Credenciales[1];
                    bono_semanal = Double.parseDouble(txtNewBonoSemanal.getText());

                    Administrador new_admin = new Administrador(id_empleado_actualizar, nombre, number_worker, experiencia, comision, " ", "Administrador", 0, bono_semanal, usuario, contraseña);

                    emp.actualizar(new_admin);
                    admin.insertar(new_admin);

                } else {
                    Empleado new_empleado = new Empleado(id_empleado_actualizar, nombre, number_worker, experiencia, comision, " ", "Trabajador");
                    emp.actualizar(new_empleado);
                }
                ser.eliminar(id_empleado_actualizar);
            }
            for (int i = 0; i < tblCargaUserService.getRowCount(); i++) {
                int idServicio = 0;
                String name_new_service = tblCargaUserService.getValueAt(i, 0).toString();
                double price_new_service = Double.parseDouble(tblCargaUserService.getValueAt(i, 1).toString());
                Servicio new_servicio = new Servicio(idServicio, name_new_service, price_new_service, id_empleado_actualizar);
                ser.insertar(new_servicio);
            }
        }
        LimpiarTodo();
        rbtnTrabajador.setSelected(true);
    }//GEN-LAST:event_btnTxtAddWorkerMouseClicked

    private void txtNewBonoSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNewBonoSemanalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNewBonoSemanalActionPerformed

    private void btnTxtAddWorker16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddWorker16MouseClicked

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField campoUsuario = new JTextField(15);
        campoUsuario.setText(Credenciales2[0]);
        JPasswordField campoContrasena = new JPasswordField(15);
        JPasswordField campoConfirmarContrasena = new JPasswordField(15);

        panel.add(new JLabel("Usuario:"));
        panel.add(campoUsuario);
        panel.add(new JLabel("Nueva contraseña:"));
        panel.add(campoContrasena);
        panel.add(new JLabel("Confirmar Contraseña:"));
        panel.add(campoConfirmarContrasena);

        int resultado = JOptionPane.showConfirmDialog(null, panel, "Registro de Usuario",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (resultado == JOptionPane.OK_OPTION) {
            String usuario = campoUsuario.getText().trim();
            String contrasena = new String(campoContrasena.getPassword());
            String confirmarContrasena = new String(campoConfirmarContrasena.getPassword());

            if (usuario.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: Credenciales en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                rbtnTrabajador.setSelected(true);
                return;
            }
            if (contrasena.equals(confirmarContrasena)) {

                if (contrasena.equals(Credenciales2[1])) {
                    JOptionPane.showMessageDialog(null, "La nueva contraseña no puede ser igual a la anterior");
                    return;
                }

                Credenciales2[0] = usuario;
                Credenciales2[1] = contrasena;
                txtNewBonoSemanal.setVisible(true);
                jLabel7.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error: Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                rbtnTrabajador.setSelected(true);
            }
        }
        if (rbtnTrabajador.isSelected()) {
            Credenciales2[0] = null;
            Credenciales2[1] = null;
        }

    }//GEN-LAST:event_btnTxtAddWorker16MouseClicked

    private void btnTxtAddWorker16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddWorker16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTxtAddWorker16MouseEntered

    private void btnTxtAddWorker16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtAddWorker16MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTxtAddWorker16MouseExited

    private void btnTxtEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtEditMouseClicked
        // TODO add your handling code here:
        int indice = tblModel.getSelectedRow();
        int id_usuario = (int) tblModel.getValueAt(indice, 0);

        if (indice != -1) {
            String rol = cboSelectTypeOf.getSelectedItem().toString();
            if ("Administrador".equals(rol)) {

                id_administrador_actualizar = id_usuario;

                rbtnAdministrador.setSelected(true);
                btnTxtAddWorker16.setVisible(true);
                pnlBtnAddWorker16.setVisible(true);
                jLabel8.setVisible(false);
                rbtnAdministrador.setVisible(false);
                rbtnTrabajador.setVisible(false);
                jLabel7.setVisible(true);
                txtNewBonoSemanal.setVisible(true);
                Administrador admin_act = admin.obtenerAdministrador(id_usuario);

                String[] nom_ape = admin_act.getNombreEmpleado().split(" ");

                id_empleado_actualizar = admin_act.getIdEmpleado();

                txtNewBonoSemanal.setText(admin_act.getBonoSemanal() + "");
                txtSetNewComision1.setText(admin_act.getPorcentajeComision() + "");
                txtSetNewExperience.setText(admin_act.getAñosExperiencia() + "");
                txtSetNewLName.setText(nom_ape[1]);
                txtSetNewName.setText(nom_ape[0]);
                txtSetNewTlf.setText(admin_act.getTelefonoEmpleado() + "");

                Credenciales2[0] = admin_act.getUsuarioAdministrador();
                Credenciales2[1] = admin_act.getPasswordAdministrador();

                for (Servicio servicio : ser.obtenerServicios(admin_act.getIdEmpleado())) {
                    String nombreServicio = servicio.getNombreServicio();
                    double precioServicio = servicio.getPrecioServicio();
                    tblCargaUserService.addRow(new Object[]{nombreServicio, precioServicio});
                }

            } else {

                id_empleado_actualizar = id_usuario;

                Empleado emp_act = emp.obtenerEmpleado(id_usuario);

                String[] nom_ape = emp_act.getNombreEmpleado().split(" ");

                txtSetNewComision1.setText(emp_act.getPorcentajeComision() + "");
                txtSetNewExperience.setText(emp_act.getAñosExperiencia() + "");
                txtSetNewLName.setText(nom_ape[1]);
                txtSetNewName.setText(nom_ape[0]);
                txtSetNewTlf.setText(emp_act.getTelefonoEmpleado() + "");

                for (Servicio servicio : ser.obtenerServicios(emp_act.getIdEmpleado())) {
                    String nombreServicio = servicio.getNombreServicio();
                    double precioServicio = servicio.getPrecioServicio();
                    tblCargaUserService.addRow(new Object[]{nombreServicio, precioServicio});
                }

                btnTxtAddWorker16.setVisible(false);
                pnlBtnAddWorker16.setVisible(false);
                jLabel8.setVisible(true);
                rbtnAdministrador.setVisible(true);
                rbtnTrabajador.setVisible(true);
                jLabel7.setVisible(false);
                txtNewBonoSemanal.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario");
            return;
        }
        btnTxtAddWorker.setText("ACTUALIZAR");
        pnlUserHistorial.setEnabled(false);
        tbdPn.setEnabled(false);
        tbdPn.setSelectedIndex(0);
        btnTxtEdit.setEnabled(false);
    }//GEN-LAST:event_btnTxtEditMouseClicked

    private void btnTxtCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseClicked
        // TODO add your handling code here:
        id_empleado_actualizar = 0;
        id_administrador_actualizar = 0;
        LimpiarTodo();
    }//GEN-LAST:event_btnTxtCancelMouseClicked

    private void btnTxtDelete1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDelete1MouseClicked
        // TODO add your handling code here:
        String rol = cboSelectTypeOf.getSelectedItem().toString();
        int indice = tblModel.getSelectedRow();
        int id_usuario = 0;
        if ("Administrador".equals(rol)) {
            id_usuario = (int) tblModel.getValueAt(indice, 0);
            admin.eliminar(id_usuario);
        } else {
            id_usuario = (int) tblModel.getValueAt(indice, 0);
            emp.eliminar(id_usuario);
        }
        MostrarUsuariosRol(rol);
    }//GEN-LAST:event_btnTxtDelete1MouseClicked

    private void cboSelectTypeOfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSelectTypeOfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSelectTypeOfActionPerformed

    private void cboSelectTypeOfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboSelectTypeOfMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cboSelectTypeOfMouseClicked

    private void cboSelectTypeOfItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSelectTypeOfItemStateChanged
        String elección = cboSelectTypeOf.getSelectedItem().toString();
        switch (elección) {
            case "Todos":
                tblTrabajador.setRowCount(0);
                tblCliente.setRowCount(0);
                cargarTablaCliente();
                MostrarUsuariosRegistrados();
                btnTxtEdit.setVisible(false);
                pnlBtnEdit.setVisible(false);

                btnTxtDelete1.setVisible(false);
                pnlBtnDelete1.setVisible(false);
                break;
            case "Cliente":
                tblTrabajador.setRowCount(0);
                tblCliente.setRowCount(0);
                cargarTablaCliente();
                MostrarClientes();
                btnTxtEdit.setVisible(false);
                pnlBtnEdit.setVisible(false);

                btnTxtDelete1.setVisible(false);
                pnlBtnDelete1.setVisible(false);
                break;
            case "Administrador":
                tblTrabajador.setRowCount(0);
                tblCliente.setRowCount(0);
                cargarTablaTrabajador();
                MostrarUsuariosRol(elección);
                btnTxtEdit.setVisible(true);
                pnlBtnEdit.setVisible(true);

                btnTxtDelete1.setVisible(true);
                btnTxtDelete1.setText("DEGRADAR");
                pnlBtnDelete1.setVisible(true);
                break;
            default:
                tblTrabajador.setRowCount(0);
                tblCliente.setRowCount(0);
                cargarTablaTrabajador();
                MostrarUsuariosRol(elección);
                btnTxtEdit.setVisible(true);
                pnlBtnEdit.setVisible(true);

                btnTxtDelete1.setVisible(true);
                btnTxtDelete1.setText("ELIMINAR");
                pnlBtnDelete1.setVisible(true);
                break;
        }
    }//GEN-LAST:event_cboSelectTypeOfItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane adsf;
    private javax.swing.ButtonGroup btnGroupAdmin;
    private javax.swing.JLabel btnTxtAddWorker;
    private javax.swing.JLabel btnTxtAddWorker16;
    private javax.swing.JLabel btnTxtCancel;
    private javax.swing.JLabel btnTxtDelete1;
    private javax.swing.JLabel btnTxtDelete2;
    private javax.swing.JLabel btnTxtEdit;
    private javax.swing.JLabel btnTxtSaveChanges2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboSelectTypeOf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlBtnAddWorker;
    private javax.swing.JPanel pnlBtnAddWorker16;
    private javax.swing.JPanel pnlBtnCancel;
    private javax.swing.JPanel pnlBtnDelete1;
    private javax.swing.JPanel pnlBtnDelete2;
    private javax.swing.JPanel pnlBtnEdit;
    private javax.swing.JPanel pnlBtnSaveChanges1;
    private javax.swing.JPanel pnlBtnSaveChanges2;
    private javax.swing.JPanel pnlContainer1;
    private javax.swing.JPanel pnlContainer2;
    private javax.swing.JPanel pnlSectionAddWorker;
    private javax.swing.JPanel pnlUserAddService;
    private javax.swing.JPanel pnlUserHistorial;
    private javax.swing.JRadioButton rbtnAdministrador;
    private javax.swing.JRadioButton rbtnTrabajador;
    private javax.swing.JTabbedPane tbdPn;
    private javax.swing.JTable tblModel;
    private javax.swing.JTable tblService;
    private javax.swing.JTable tblUserService;
    private javax.swing.JTextField txtNewBonoSemanal;
    private javax.swing.JTextField txtSetNewComision1;
    private javax.swing.JTextField txtSetNewExperience;
    private javax.swing.JTextField txtSetNewLName;
    private javax.swing.JTextField txtSetNewName;
    private javax.swing.JTextField txtSetNewNameService1;
    private javax.swing.JTextField txtSetNewPriceService;
    private javax.swing.JTextField txtSetNewTlf;
    // End of variables declaration//GEN-END:variables
}
