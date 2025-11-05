package Implementación;

import Modelo.Administrador;
import ModeloDAO.AdministradorDAO;
import SQL_Conection.SQL_Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AdminMethod implements AdministradorDAO {

    @Override
    public int iniciarSesion(String usuario, String password) {
        Connection conexion = null;
        PreparedStatement state = null;
        ResultSet resultado = null;
        int idEmpleado = 0;
        try {
            String consulta = "SELECT * FROM administrador WHERE usuario = ? AND contraseña = ?";
            conexion = SQL_Conexion.conectar();
            state = conexion.prepareStatement(consulta);
            state.setString(1, usuario);
            state.setString(2, password);
            resultado = state.executeQuery();

            if (resultado.next()) {
                idEmpleado = resultado.getInt("idEmpleado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cerrarRecursos(conexion, state, resultado);
        }
        return idEmpleado;
    }

    @Override
    public void insertar(Administrador admin) {
        Connection conexion = null;
        PreparedStatement state = null;
        try {
            conexion = SQL_Conexion.conectar();
            String consultaActualizar = "UPDATE Empleado SET rol = 'Administrador' WHERE idEmpleado = ?";
            state = conexion.prepareStatement(consultaActualizar);
            state.setInt(1, admin.getIdEmpleado());
            state.executeUpdate();

            String consultaInsertar = "INSERT INTO administrador (bonoSemanal, usuario, contraseña, idEmpleado) VALUES (?, ?, ?, ?)";
            state = conexion.prepareStatement(consultaInsertar);
            state.setDouble(1, admin.getBonoSemanal());
            state.setString(2, admin.getUsuarioAdministrador());
            state.setString(3, admin.getPasswordAdministrador());
            state.setInt(4, admin.getIdEmpleado());
            state.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar al administrador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            cerrarRecursos(conexion, state, null);
        }
    }

    @Override
    public void eliminar(int idAdministrador) {
        Connection conexion = null;
        PreparedStatement state1 = null, state2 = null;
        try {
            conexion = SQL_Conexion.conectar();
            String consulta1 = "UPDATE Empleado SET rol = 'Trabajador' WHERE idEmpleado = (SELECT idEmpleado FROM Administrador WHERE idAdministrador = ?)";
            String consulta2 = "DELETE FROM Administrador WHERE idAdministrador = ?";
            state1 = conexion.prepareStatement(consulta1);
            state2 = conexion.prepareStatement(consulta2);
            state1.setInt(1, idAdministrador);
            state2.setInt(1, idAdministrador);
            state1.executeUpdate();
            state2.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario no cuenta con servicios registrados: " + e);
        } finally {
            cerrarRecursos(conexion, state1, null);
        }
    }

    @Override
    public void actualizar(Administrador admin) {
        Connection conexion = null;
        PreparedStatement state = null;
        try {
            conexion = SQL_Conexion.conectar();
            String consulta = "UPDATE administrador SET bonoSemanal = ?, usuario = ?, contraseña = ? WHERE idEmpleado = ?";
            state = conexion.prepareStatement(consulta);
            state.setDouble(1, admin.getBonoSemanal());
            state.setString(2, admin.getUsuarioAdministrador());
            state.setString(3, admin.getPasswordAdministrador());
            state.setInt(4, admin.getIdEmpleado());
            state.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar las credenciales del administrador: " + e.getMessage());
        } finally {
            cerrarRecursos(conexion, state, null);
        }
    }

    @Override
    public List<Administrador> listarAdministrador() {
        List<Administrador> lista_administrador = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement state = null;
        ResultSet resultado = null;
        try {
            String consulta = "SELECT a.idAdministrador, a.bonoSemanal, a.usuario, a.contraseña, e.idEmpleado, e.nombreEmpleado, e.telefonoEmpleado, e.añosExperiencia, e.porcentajeComision, e.fechaRegistro, e.rol "
                    + "FROM empleado e JOIN administrador a ON e.idEmpleado = a.idEmpleado WHERE e.rol = 'Administrador'";
            conexion = SQL_Conexion.conectar();
            state = conexion.prepareStatement(consulta);
            resultado = state.executeQuery();
            while (resultado.next()) {
                Administrador newAdministrador = new Administrador(
                        resultado.getInt("idEmpleado"),
                        resultado.getString("nombreEmpleado"),
                        resultado.getInt("telefonoEmpleado"),
                        resultado.getInt("añosExperiencia"),
                        resultado.getDouble("porcentajeComision"),
                        resultado.getString("fechaRegistro"),
                        resultado.getString("rol"),
                        resultado.getInt("idAdministrador"),
                        resultado.getDouble("bonoSemanal"),
                        resultado.getString("usuario"),
                        resultado.getString("contraseña")
                );
                lista_administrador.add(newAdministrador);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Todavía no hay trabajadores registrados");
        } finally {
            cerrarRecursos(conexion, state, resultado);
        }
        return lista_administrador;
    }

    @Override
    public Administrador obtenerAdministrador(int idAdministrador) {
        Administrador newAdministrador = null;
        Connection conexion = null;
        PreparedStatement state = null;
        ResultSet resultado = null;
        try {
            String consulta = "SELECT a.idAdministrador, a.bonoSemanal, a.usuario, a.contraseña, e.idEmpleado, e.nombreEmpleado, e.telefonoEmpleado, e.añosExperiencia, e.porcentajeComision, e.fechaRegistro, e.rol "
                    + "FROM empleado e JOIN administrador a ON e.idEmpleado = a.idEmpleado WHERE e.rol = 'Administrador' AND a.idAdministrador = ?";
            conexion = SQL_Conexion.conectar();
            state = conexion.prepareStatement(consulta);
            state.setInt(1, idAdministrador);
            resultado = state.executeQuery();
            if (resultado.next()) {
                newAdministrador = new Administrador(
                        resultado.getInt("idEmpleado"),
                        resultado.getString("nombreEmpleado"),
                        resultado.getInt("telefonoEmpleado"),
                        resultado.getInt("añosExperiencia"),
                        resultado.getDouble("porcentajeComision"),
                        resultado.getString("fechaRegistro"),
                        resultado.getString("rol"),
                        resultado.getInt("idAdministrador"),
                        resultado.getDouble("bonoSemanal"),
                        resultado.getString("usuario"),
                        resultado.getString("contraseña")
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el administrador");
        } finally {
            cerrarRecursos(conexion, state, resultado);
        }
        return newAdministrador;
    }

    private void cerrarRecursos(Connection conexion, PreparedStatement state, ResultSet resultado) {
        try {
            if (resultado != null) resultado.close();
            if (state != null) state.close();
            if (conexion != null) conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar los recursos: " + e.getMessage());
        }
    }
}
