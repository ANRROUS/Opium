package Implementación;

import Modelo.Incidencia;
import ModeloDAO.IncidenciaDAO;
import SQL_Conection.SQL_Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class IncMethod implements IncidenciaDAO {

    @Override
    public void insertar(Incidencia i) {
        String consulta = "INSERT INTO `incidencia` (`idRecibo`, `tipoIncidencia`, `montoAdicional`, `descuentoTrabajador`, `fechaIncidencia`) VALUES (?, ?, ?, ?, NOW());";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setInt(1, i.getIdRecibo());
            state.setString(2, i.getTipoIncidencia());
            state.setDouble(3, i.getMontoAdicional());
            state.setDouble(4, i.getMontoDescuento());

            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Incidencia registrada exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la incidencia: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void eliminar(int idIncidencia) {
        String consulta = "DELETE FROM incidencia WHERE idIncidencia = ?";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setInt(1, idIncidencia);
            int filasAfectadas = state.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Incidencia eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una incidencia con el ID especificado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la incidencia: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Incidencia> listarIncidencia() {
        List<Incidencia> lista_incidencia = new ArrayList<>();
        String consulta = "SELECT * FROM `incidencia`";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta);
             ResultSet resultado = state.executeQuery()) {

            while (resultado.next()) {
                int idIncidencia = resultado.getInt("idIncidencia");
                int idRecibo = resultado.getInt("idRecibo");
                String tipoIncidencia = resultado.getString("tipoIncidencia");
                double montoAdicional = resultado.getDouble("montoAdicional");
                double descuentoTrabajador = resultado.getDouble("descuentoTrabajador");
                String fechaIncidencia = resultado.getString("fechaIncidencia");

                Incidencia newIncidencia = new Incidencia(idIncidencia, idRecibo, tipoIncidencia, montoAdicional, descuentoTrabajador, fechaIncidencia);
                lista_incidencia.add(newIncidencia);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar incidencias: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lista_incidencia;
    }
}
