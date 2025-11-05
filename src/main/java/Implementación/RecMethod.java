package Implementación;

import Modelo.Recibo;
import ModeloDAO.ReciboDAO;
import SQL_Conection.SQL_Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RecMethod implements ReciboDAO {

    @Override
    public void insertar(Recibo r) {

        String consulta = "INSERT INTO `recibo` (`idServicio`, `nproductoVendido`, `montoServicio`, `idEmpleado`, `idCliente`, `fechaRecibo`) VALUES (?, ?, ?, ?, ?, NOW());";

        try (Connection conexion = SQL_Conexion.conectar(); PreparedStatement state = conexion.prepareStatement(consulta)) {
            
            state.setInt(1, r.getIdServicio());
            state.setInt(2, r.getNumProducto());
            state.setDouble(3, r.getMontoServicio());
            state.setInt(4, r.getIdEmpleado());
            state.setInt(5, r.getIdCliente());

            state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar el Recibo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void modificar(Recibo r) {

        Connection conexion = null;
        PreparedStatement state = null;

        try {
            conexion = SQL_Conexion.conectar();
            String consulta = "UPDATE `recibo` SET idServicio = ?, nproductoVendido = ?, montoServicio = ?, idEmpleado = ?, idCliente = ?, fechaRecibo = NOW() WHERE idRecibo = ?";
            state = conexion.prepareStatement(consulta);
            state.setInt(1, r.getIdServicio());
            state.setInt(2, r.getNumProducto());
            state.setDouble(3, r.getMontoServicio());
            state.setInt(4, r.getIdEmpleado());
            state.setInt(5, r.getIdCliente());
            state.setInt(6, r.getIdRecibo());
            state.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario no cuenta con servicios registrados: " + e);
        }

    }

    @Override
    public List<Recibo> listarRecibo() {

        List<Recibo> lista_recibo = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM `recibo`";
            Connection conexion = SQL_Conexion.conectar();
            PreparedStatement state = conexion.prepareStatement(consulta);
            ResultSet resultado = state.executeQuery();
            while (resultado.next()) {
                int idRecibo =  resultado.getInt("idRecibo");
                int idServicio = resultado.getInt("idServicio");
                int numProducto = resultado.getInt("nproductoVendido");
                double montoServicio = resultado.getDouble("montoServicio");
                int idEmpleado = resultado.getInt("idEmpleado");
                int idCliente = resultado.getInt("idCliente");
                String fechaRecibo = resultado.getString("fechaRecibo");
                
                Recibo newRecibo = new Recibo(idRecibo, idServicio, numProducto, montoServicio, idEmpleado, idCliente, fechaRecibo);

                lista_recibo.add(newRecibo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Todavía no trabajadores registrados");
        }

        return lista_recibo;

    }

    @Override
    public Recibo obtenerRecibo(int idRecibo) {

        Recibo newRecibo = null;
        
        try {
            String consulta = "SELECT * FROM `recibo` where idRecibo = ?";
            Connection conexion = SQL_Conexion.conectar();
            PreparedStatement state = conexion.prepareStatement(consulta);
            state.setInt(1, idRecibo);
            ResultSet resultado = state.executeQuery();
            if (resultado.next()) {
                int idServicio = resultado.getInt("idServicio");
                int numProducto = resultado.getInt("nproductoVendido");
                double montoServicio = resultado.getDouble("montoServicio");
                int idEmpleado = resultado.getInt("idEmpleado");
                int idCliente = resultado.getInt("idCliente");
                String fechaRecibo = resultado.getString("fechaRecibo");
                
                newRecibo = new Recibo(idRecibo, idServicio, numProducto, montoServicio, idEmpleado, idCliente, fechaRecibo);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Todavía no trabajadores registrados");
        }

        return newRecibo;

    }

    @Override
    public void eliminar(int idRecibo) {

        Connection conexion = null;
        PreparedStatement state = null;
        try {
            conexion = SQL_Conexion.conectar();
            String consulta = "delete from recibo where idRecibo = ?";
            state = conexion.prepareStatement(consulta);
            state.setInt(1, idRecibo);
            state.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario no cuenta con servicios registrados: " + e);
        } 
        
    }

    @Override
    public List<Recibo> listarReciboDia(int Day) {

        List<Recibo> lista_recibo = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM `recibo` WHERE DAYOFWEEK(fechaRecibo) = ?";
            Connection conexion = SQL_Conexion.conectar();
            PreparedStatement state = conexion.prepareStatement(consulta);
            state.setInt(1, Day);
            ResultSet resultado = state.executeQuery();
            while (resultado.next()) {
                int idRecibo =  resultado.getInt("idRecibo");
                int idServicio = resultado.getInt("idServicio");
                int numProducto = resultado.getInt("nproductoVendido");
                double montoServicio = resultado.getDouble("montoServicio");
                int idEmpleado = resultado.getInt("idEmpleado");
                int idCliente = resultado.getInt("idCliente");
                String fechaRecibo = resultado.getString("fechaRecibo");
                
                Recibo newRecibo = new Recibo(idRecibo, idServicio, numProducto, montoServicio, idEmpleado, idCliente, fechaRecibo);

                lista_recibo.add(newRecibo);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Todavía no trabajadores registrados");
        }

        return lista_recibo;
        
    }

}
