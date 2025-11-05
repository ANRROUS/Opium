package Implementación;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import SQL_Conection.SQL_Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CliMethod implements ClienteDAO {

    @Override
    public void insertar(Cliente c) {
        String consulta = "INSERT INTO `cliente` (`nombreCliente`, `telefonoCliente`, `fechaRegistro`) VALUES (?, ?, NOW());";

        // Usando try-with-resources para asegurar el cierre de conexión y PreparedStatement
        try (Connection conexion = SQL_Conexion.conectar(); 
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setString(1, c.getNombreCliente());
            state.setInt(2, c.getNumeroCliente());

            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar al Cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Cliente> listarCliente() {
        List<Cliente> lista_cliente = new ArrayList<>();
        String consulta = "SELECT * FROM `cliente`";

        // Usando try-with-resources para asegurar el cierre de conexión y recursos
        try (Connection conexion = SQL_Conexion.conectar(); 
             PreparedStatement state = conexion.prepareStatement(consulta); 
             ResultSet resultado = state.executeQuery()) {

            while (resultado.next()) {
                int idCliente = resultado.getInt("idCliente");
                String nombreCliente = resultado.getString("nombreCliente");
                int telefonoCliente = resultado.getInt("telefonoCliente");
                String fechaRegistro = resultado.getString("fechaRegistro");

                Cliente newCliente = new Cliente(idCliente, nombreCliente, telefonoCliente, fechaRegistro);
                lista_cliente.add(newCliente);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return lista_cliente;
    }

    @Override
    public Cliente obtenerCliente(int idCliente) {
        Cliente newCliente = null;
        String consulta = "SELECT * FROM `cliente` WHERE idCliente = ?";

        // Usando try-with-resources para asegurar el cierre de conexión y recursos
        try (Connection conexion = SQL_Conexion.conectar(); 
             PreparedStatement state = conexion.prepareStatement(consulta)) {

            state.setInt(1, idCliente);
            try (ResultSet resultado = state.executeQuery()) {
                if (resultado.next()) {
                    String nombreCliente = resultado.getString("nombreCliente");
                    int telefonoCliente = resultado.getInt("telefonoCliente");
                    String fechaRegistro = resultado.getString("fechaRegistro");

                    newCliente = new Cliente(idCliente, nombreCliente, telefonoCliente, fechaRegistro);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return newCliente;
    }
}
