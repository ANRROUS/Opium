package Implementación;

import Modelo.Pago;
import ModeloDAO.PagoDAO;
import SQL_Conection.SQL_Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PagMethod implements PagoDAO {

    @Override
    public void insertar(Pago p) {
        String consulta = "INSERT INTO `pagos` (`idEmpleado`, `fecha`, `comisionSemanal`) VALUES (?, NOW(), ?);";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setInt(1, p.getIdEmpleado());
            state.setDouble(2, p.getMontoPago());

            state.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el pago: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Pago> listarPago() {
        List<Pago> listaPago = new ArrayList<>();
        String consulta = "SELECT * FROM `pagos`";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta);
             ResultSet resultado = state.executeQuery()) {

            while (resultado.next()) {
                int idPago = resultado.getInt("idPago");
                int idEmpleado = resultado.getInt("idEmpleado");
                String fechaPago = resultado.getString("fecha");
                double comisionSemanal = resultado.getDouble("comisionSemanal");

                Pago newPago = new Pago(idPago, idEmpleado, fechaPago, comisionSemanal);
                listaPago.add(newPago);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los pagos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return listaPago;
    }

    @Override
    public List<Pago> obtenerPago(String fechaRecibo) {
        List<Pago> listaPago = new ArrayList<>();
        String consulta = "SELECT * FROM `pagos` WHERE fecha = ?";

        // Uso de try-with-resources
        try (Connection conexion = SQL_Conexion.conectar();
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setString(1, fechaRecibo);
            try (ResultSet resultado = state.executeQuery()) {
                while (resultado.next()) {
                    int idPago = resultado.getInt("idPago");
                    int idEmpleado = resultado.getInt("idEmpleado");
                    String fechaPago = resultado.getString("fecha");
                    double comisionSemanal = resultado.getDouble("comisionSemanal");

                    Pago newPago = new Pago(idPago, idEmpleado, fechaPago, comisionSemanal);
                    listaPago.add(newPago);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los pagos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return listaPago;
    }
}
