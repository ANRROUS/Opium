package Vista;

import Implementación.AdminMethod;
import Implementación.EmpMethod;
import Implementación.IncMethod;
import Implementación.PagMethod;
import Implementación.RecMethod;
import Modelo.Administrador;
import Modelo.Empleado;
import Modelo.Incidencia;
import Modelo.Pago;
import Modelo.Recibo;
import java.awt.Color;
import java.awt.Font;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ComisionVista extends javax.swing.JPanel {

    EmpMethod emp = new EmpMethod();
    AdminMethod admin = new AdminMethod();
    RecMethod rec = new RecMethod();
    IncMethod inc = new IncMethod();
    PagMethod pag = new PagMethod();

    //objetos
    private DefaultTableModel tblPreComision = new DefaultTableModel();
    private DefaultTableModel tblComision = new DefaultTableModel();

    public ComisionVista() {
        initComponents();
        cargarTablaComision();
        cargarTablaPreComision();
        MostrarPagos();
        disenoTablas();
        txtSetFrom.setText(LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toString());
        txtSetTo.setText(LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toString());
    }

    private void LimpiarTodo() {
        tblPreComision.setRowCount(0);
        txtAShowDays.setText("");
        cboSelectDay.removeAllItems();

        String[] opciones = {"Seleccionar", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for (String opcion : opciones) {
            cboSelectDay.addItem(opcion);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlCalculateComission = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSetFrom = new javax.swing.JTextField();
        txtSetTo = new javax.swing.JTextField();
        cboSelectDay = new javax.swing.JComboBox<>();
        pnlBtnDeleteDay = new javax.swing.JPanel();
        btnTxtDeleteDay = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAShowDays = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPreModel = new javax.swing.JTable();
        pnlBtnSaveComision = new javax.swing.JPanel();
        btnTxtSaveComision = new javax.swing.JLabel();
        pnlBtnCancel = new javax.swing.JPanel();
        btnTxtCancel = new javax.swing.JLabel();
        pnlBtnCalculate = new javax.swing.JPanel();
        btnTxtCalculate = new javax.swing.JLabel();
        pnlContainerTable = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtSearchByDate = new com.toedter.calendar.JDateChooser();
        pnlBtnSearch = new javax.swing.JPanel();
        btnTxtSearch = new javax.swing.JLabel();
        pnlBtnCancel2 = new javax.swing.JPanel();
        btnTxtCancel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblModel = new javax.swing.JTable();

        setBackground(new java.awt.Color(248, 244, 236));
        setPreferredSize(new java.awt.Dimension(1096, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("MODIFICAR COMISIONES DE TRABAJADORES");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        pnlCalculateComission.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        pnlCalculateComission.setPreferredSize(new java.awt.Dimension(440, 530));
        pnlCalculateComission.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("COMISIONES");
        pnlCalculateComission.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("Desde:");
        pnlCalculateComission.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Hasta:");
        pnlCalculateComission.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Seleccionar días feriados:");
        pnlCalculateComission.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Comisión de los trabajadores: ");
        pnlCalculateComission.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        txtSetFrom.setBackground(new java.awt.Color(242, 242, 242));
        txtSetFrom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetFrom.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlCalculateComission.add(txtSetFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 100, 30));

        txtSetTo.setBackground(new java.awt.Color(242, 242, 242));
        txtSetTo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSetTo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlCalculateComission.add(txtSetTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 100, 30));

        cboSelectDay.setBackground(new java.awt.Color(242, 242, 242));
        cboSelectDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" }));
        cboSelectDay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cboSelectDay.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        cboSelectDay.setFocusable(false);
        cboSelectDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSelectDayActionPerformed(evt);
            }
        });
        pnlCalculateComission.add(cboSelectDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, 40));

        pnlBtnDeleteDay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnDeleteDay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtDeleteDay.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtDeleteDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtDeleteDay.setText("Eliminar");
        btnTxtDeleteDay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtDeleteDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtDeleteDayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtDeleteDayMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtDeleteDayMouseExited(evt);
            }
        });
        btnTxtDeleteDay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                btnTxtDeleteDayPropertyChange(evt);
            }
        });
        pnlBtnDeleteDay.add(btnTxtDeleteDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        pnlCalculateComission.add(pnlBtnDeleteDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 120, 40));

        txtAShowDays.setEditable(false);
        txtAShowDays.setColumns(20);
        txtAShowDays.setLineWrap(false);
        txtAShowDays.setRows(5);
        txtAShowDays.setAutoscrolls(false);
        jScrollPane2.setViewportView(txtAShowDays);

        pnlCalculateComission.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 390, 30));

        jScrollPane3.setWheelScrollingEnabled(false);

        tblPreModel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPreModel);

        pnlCalculateComission.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 390, 190));

        pnlBtnSaveComision.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnSaveComision.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtSaveComision.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtSaveComision.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtSaveComision.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconCheck.png"))); // NOI18N
        btnTxtSaveComision.setText("GUARDAR");
        btnTxtSaveComision.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtSaveComision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtSaveComisionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtSaveComisionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtSaveComisionMouseExited(evt);
            }
        });
        pnlBtnSaveComision.add(btnTxtSaveComision, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        pnlCalculateComission.add(pnlBtnSaveComision, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 150, 40));

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

        pnlCalculateComission.add(pnlBtnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 150, 40));

        pnlBtnCalculate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnCalculate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtCalculate.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnTxtCalculate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtCalculate.setText("Calcular");
        btnTxtCalculate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtCalculate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtCalculateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtCalculateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtCalculateMouseExited(evt);
            }
        });
        pnlBtnCalculate.add(btnTxtCalculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        pnlCalculateComission.add(pnlBtnCalculate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 120, 40));

        add(pnlCalculateComission, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 440, 530));

        pnlContainerTable.setBackground(new java.awt.Color(248, 244, 236));
        pnlContainerTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        pnlContainerTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel7.setText("HISTORIAL:");
        pnlContainerTable.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtSearchByDate.setFocusable(false);
        pnlContainerTable.add(txtSearchByDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 130, 30));

        pnlBtnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnSearch.setPreferredSize(new java.awt.Dimension(130, 30));
        pnlBtnSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconSearch.png"))); // NOI18N
        btnTxtSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtSearchMouseExited(evt);
            }
        });
        pnlBtnSearch.add(btnTxtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        pnlContainerTable.add(pnlBtnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 60, -1));

        pnlBtnCancel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBtnCancel2.setPreferredSize(new java.awt.Dimension(130, 30));
        pnlBtnCancel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTxtCancel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTxtCancel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconClear.png"))); // NOI18N
        btnTxtCancel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTxtCancel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTxtCancel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTxtCancel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTxtCancel2MouseExited(evt);
            }
        });
        pnlBtnCancel2.add(btnTxtCancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        pnlContainerTable.add(pnlBtnCancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 60, -1));

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
        jScrollPane4.setViewportView(tblModel);

        pnlContainerTable.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 600, 440));

        add(pnlContainerTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 656, 530));
    }// </editor-fold>//GEN-END:initComponents

    private void disenoTablas() {
        tblPreModel.setRowHeight(30);
        tblPreModel.getTableHeader().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblPreModel.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblModel.setRowHeight(30);
        tblModel.getTableHeader().setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        tblModel.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
    }

    private void cargarTablaPreComision() {
        if (tblPreComision.getColumnCount() == 0) {
            tblPreComision.addColumn("Id");
            tblPreComision.addColumn("Nombre");
            tblPreComision.addColumn("Monto");
            tblPreModel.setModel(tblPreComision);
        }
    }

    private void cargarTablaComision() {
        if (tblComision.getColumnCount() == 0) {
            tblComision.addColumn("Id");
            tblComision.addColumn("Nombre");
            tblComision.addColumn("Comision");
            tblComision.addColumn("Fecha");
            tblModel.setModel(tblComision);
        }
    }

    private void MostrarPagos() {
        tblComision.setRowCount(0);

        for (Pago pago : pag.listarPago()) {
            Empleado empleado = emp.obtenerEmpleado(pago.getIdEmpleado());
            tblComision.addRow(new Object[]{pago.getIdPago(), empleado.getNombreEmpleado(), pago.getMontoPago(), pago.getFechaPago()});
        }

    }

    // Estilos del panel
    private void btnTxtSaveComisionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveComisionMouseEntered
        pnlBtnSaveComision.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtSaveComisionMouseEntered

    private void btnTxtSaveComisionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveComisionMouseExited
        pnlBtnSaveComision.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtSaveComisionMouseExited

    private void btnTxtDeleteDayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDeleteDayMouseEntered
        pnlBtnDeleteDay.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtDeleteDayMouseEntered

    private void btnTxtDeleteDayMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDeleteDayMouseExited
        pnlBtnDeleteDay.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtDeleteDayMouseExited

    private void btnTxtCancel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancel2MouseEntered
        pnlBtnCancel2.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtCancel2MouseEntered

    private void btnTxtCancel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancel2MouseExited
        pnlBtnCancel2.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtCancel2MouseExited

    private void btnTxtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSearchMouseEntered
        pnlBtnSearch.setBackground(new Color(207, 207, 207));
    }//GEN-LAST:event_btnTxtSearchMouseEntered

    private void btnTxtSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSearchMouseExited
        pnlBtnSearch.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtSearchMouseExited

    private void btnTxtCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseEntered
        pnlBtnCancel.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtCancelMouseEntered

    private void btnTxtCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseExited
        pnlBtnCancel.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtCancelMouseExited

    private void cboSelectDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSelectDayActionPerformed

        Object selectedItem = cboSelectDay.getSelectedItem();

        if (selectedItem != null) {
            String day = selectedItem.toString();

            if (!"Seleccionar".equals(day)) {
                if (txtAShowDays.getText().isEmpty()) {
                    txtAShowDays.append(day);
                } else {
                    txtAShowDays.append(", " + day);
                }

                cboSelectDay.removeItemAt(cboSelectDay.getSelectedIndex());

                if (cboSelectDay.getItemCount() > 0) {
                    cboSelectDay.setSelectedItem("Seleccionar");
                }
            }
        } else {
            System.out.println("No hay elemento seleccionado.");
        }

    }//GEN-LAST:event_cboSelectDayActionPerformed

    private void btnTxtDeleteDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtDeleteDayMouseClicked

        LimpiarTodo();

    }//GEN-LAST:event_btnTxtDeleteDayMouseClicked

    private void btnTxtCalculateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCalculateMouseEntered
        pnlBtnCalculate.setBackground(new Color(252, 244, 228));
    }//GEN-LAST:event_btnTxtCalculateMouseEntered

    private void btnTxtCalculateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCalculateMouseExited
        pnlBtnCalculate.setBackground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnTxtCalculateMouseExited

    private void btnTxtDeleteDayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_btnTxtDeleteDayPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTxtDeleteDayPropertyChange

    private void btnTxtCalculateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCalculateMouseClicked

        tblPreComision.setRowCount(0);
        String[] feriados = Arrays.stream(txtAShowDays.getText().trim().split(","))
                .map(String::trim)
                .toArray(String[]::new);

        Set<Integer> feriadosNumerosSet = new HashSet<>();

        for (String dia : feriados) {
            switch (dia) {
                case "Lunes":
                    feriadosNumerosSet.add(2);
                    break;
                case "Martes":
                    feriadosNumerosSet.add(3);
                    break;
                case "Miércoles":
                    feriadosNumerosSet.add(4);
                    break;
                case "Jueves":
                    feriadosNumerosSet.add(5);
                    break;
                case "Viernes":
                    feriadosNumerosSet.add(6);
                    break;
                case "Sábado":
                    feriadosNumerosSet.add(7);
                    break;
                case "Domingo":
                    feriadosNumerosSet.add(1);
                    break;
            }
        }

        for (Empleado empleado : emp.listarEmpleado()) {

            double ganancia = 0;

            int idEmpleado = empleado.getIdEmpleado();
            String nombreEmpleado = empleado.getNombreEmpleado();
            double comisionEmpleado = empleado.getPorcentajeComision();

            for (Administrador administrador : admin.listarAdministrador()) {
                if (administrador.getIdEmpleado() == idEmpleado) {
                    ganancia += administrador.getBonoSemanal();
                }
            }

            for (int dia = 1; dia <= 7; dia++) {
                for (Recibo recibo : rec.listarReciboDia(dia)) {
                    if (recibo.getIdEmpleado() == idEmpleado) {
                        int idRecibo = recibo.getIdRecibo();
                        double montoRecibo = recibo.getMontoServicio();
                        int numProductosRecibo = recibo.getNumProducto();
                        for (Incidencia incidencia : inc.listarIncidencia()) {
                            if (idRecibo == incidencia.getIdRecibo()) {
                                montoRecibo += incidencia.getMontoAdicional();
                                ganancia -= incidencia.getMontoDescuento();
                            }
                        }
                        ganancia += numProductosRecibo * 5;
                        if (feriadosNumerosSet.contains(dia)) {
                            ganancia += montoRecibo * 0.5;
                        } else {
                            ganancia += montoRecibo * (comisionEmpleado / 100);
                        }
                    }
                }
            }
            tblPreComision.addRow(new Object[]{idEmpleado, nombreEmpleado, ganancia});
        }

    }//GEN-LAST:event_btnTxtCalculateMouseClicked

    private void btnTxtSaveComisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSaveComisionMouseClicked

        for (int i = 0; i < tblPreComision.getRowCount(); i++) {
            Pago pago = new Pago(0, (int) tblPreModel.getValueAt(i, 0), " ", (double) tblPreModel.getValueAt(i, 2));
            pag.insertar(pago);
        }
        
        MostrarPagos();
        LimpiarTodo();
    }//GEN-LAST:event_btnTxtSaveComisionMouseClicked

    private void btnTxtCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancelMouseClicked
        // TODO add your handling code here:
        LimpiarTodo();
    }//GEN-LAST:event_btnTxtCancelMouseClicked

    private void btnTxtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtSearchMouseClicked
        tblComision.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date fechaSel = txtSearchByDate.getDate();
        if (fechaSel != null) {
            LocalDate localFechaSel = fechaSel.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            for (Pago pago : pag.listarPago()) {
                String fechaRecibo = pago.getFechaPago();
                LocalDate localFechaRecibo = LocalDate.parse(fechaRecibo, formatter);
                if (localFechaSel.equals(localFechaRecibo)) {
                    Empleado empleado = emp.obtenerEmpleado(pago.getIdEmpleado());
                    tblComision.addRow(new Object[]{
                        pago.getIdPago(),
                        empleado.getNombreEmpleado(),
                        pago.getMontoPago(),
                        pago.getFechaPago()
                    });
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fecha.");
        }
    }//GEN-LAST:event_btnTxtSearchMouseClicked

    private void btnTxtCancel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTxtCancel2MouseClicked
        // TODO add your handling code here:
        txtSearchByDate.setDate(null);
        LimpiarTodo();
        MostrarPagos();
    }//GEN-LAST:event_btnTxtCancel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnTxtCalculate;
    private javax.swing.JLabel btnTxtCancel;
    private javax.swing.JLabel btnTxtCancel2;
    private javax.swing.JLabel btnTxtDeleteDay;
    private javax.swing.JLabel btnTxtSaveComision;
    private javax.swing.JLabel btnTxtSearch;
    private javax.swing.JComboBox<String> cboSelectDay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlBtnCalculate;
    private javax.swing.JPanel pnlBtnCancel;
    private javax.swing.JPanel pnlBtnCancel2;
    private javax.swing.JPanel pnlBtnDeleteDay;
    private javax.swing.JPanel pnlBtnSaveComision;
    private javax.swing.JPanel pnlBtnSearch;
    private javax.swing.JPanel pnlCalculateComission;
    private javax.swing.JPanel pnlContainerTable;
    private javax.swing.JTable tblModel;
    private javax.swing.JTable tblPreModel;
    private javax.swing.JTextArea txtAShowDays;
    private com.toedter.calendar.JDateChooser txtSearchByDate;
    private javax.swing.JTextField txtSetFrom;
    private javax.swing.JTextField txtSetTo;
    // End of variables declaration//GEN-END:variables
}
