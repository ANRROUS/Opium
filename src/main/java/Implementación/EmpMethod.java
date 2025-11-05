package Implementación;

import Modelo.Empleado;
import ModeloDAO.EmpleadoDAO;
import SQL_Conection.SQL_Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EmpMethod implements EmpleadoDAO {

    @Override
    public void insertar(Empleado e) {
        String consulta = "INSERT INTO `empleado` (`nombreEmpleado`, `telefonoEmpleado`, `añosExperiencia`, `porcentajeComision`, `fechaRegistro`, `rol`) VALUES (?, ?, ?, ?, NOW(), ?);";

        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setString(1, e.getNombreEmpleado());
            state.setInt(2, e.getTelefonoEmpleado());
            state.setInt(3, e.getAñosExperiencia());
            state.setDouble(4, e.getPorcentajeComision());
            state.setString(5, e.getRolEmpleado());

            state.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpMethod.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int idEmpleado) {
        String consulta = "UPDATE empleado SET rol = 'Ninguno' WHERE idEmpleado = ?;";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setInt(1, idEmpleado);
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado eliminado exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actualizar(Empleado e) {
        String consulta = "UPDATE empleado SET nombreEmpleado = ?, telefonoEmpleado = ?, añosExperiencia = ?, porcentajeComision = ?, rol = ?, fechaRegistro = NOW() WHERE idEmpleado = ?";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setString(1, e.getNombreEmpleado());
            state.setInt(2, e.getTelefonoEmpleado());
            state.setInt(3, e.getAñosExperiencia());
            state.setDouble(4, e.getPorcentajeComision());
            state.setString(5, e.getRolEmpleado());
            state.setInt(6, e.getIdEmpleado());

            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Empleado> listarEmpleado() {
        List<Empleado> lista_empleado = new ArrayList<>();
        String consulta = "SELECT * FROM `empleado` WHERE rol <> 'Ninguno'";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta);
             ResultSet resultado = state.executeQuery()) {

            while (resultado.next()) {
                int idEmpleado = resultado.getInt("idEmpleado");
                String nombreEmpleado = resultado.getString("nombreEmpleado");
                int numeroEmpleado = resultado.getInt("telefonoEmpleado");
                int añosExperiencia = resultado.getInt("añosExperiencia");
                double porcentajeComision = resultado.getDouble("porcentajeComision");
                String fechaRegistro = resultado.getString("fechaRegistro");
                String rolEmpleado = resultado.getString("rol");

                Empleado newEmpleado = new Empleado(idEmpleado, nombreEmpleado, numeroEmpleado, añosExperiencia, porcentajeComision, fechaRegistro, rolEmpleado);
                lista_empleado.add(newEmpleado);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar empleados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lista_empleado;
    }

    @Override
    public Empleado obtenerEmpleado(int idEmpleado) {
        Empleado newEmpleado = null;
        String consulta = "SELECT * FROM `empleado` WHERE rol <> 'Ninguno' AND idEmpleado = ?";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setInt(1, idEmpleado);
            try (ResultSet resultado = state.executeQuery()) {
                if (resultado.next()) {
                    String nombreEmpleado = resultado.getString("nombreEmpleado");
                    int numeroEmpleado = resultado.getInt("telefonoEmpleado");
                    int añosExperiencia = resultado.getInt("añosExperiencia");
                    double porcentajeComision = resultado.getDouble("porcentajeComision");
                    String fechaRegistro = resultado.getString("fechaRegistro");
                    String rolEmpleado = resultado.getString("rol");

                    newEmpleado = new Empleado(idEmpleado, nombreEmpleado, numeroEmpleado, añosExperiencia, porcentajeComision, fechaRegistro, rolEmpleado);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el empleado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return newEmpleado;
    }
}
