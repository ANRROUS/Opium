package Implementación;

import Modelo.Servicio;
import ModeloDAO.ServicioDAO;
import SQL_Conection.SQL_Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SerMethod implements ServicioDAO {

    @Override
    public void insertar(Servicio s) {

        Connection conexion = null;
        PreparedStatement state = null;

        try {

            String consulta = "INSERT INTO `servicio` (`nombreServicio`, `precio`, `idEmpleado`) VALUES (?, ?, ?);";

            conexion = SQL_Conexion.conectar();
            state = conexion.prepareStatement(consulta);

            state.setString(1, s.getNombreServicio());
            state.setDouble(2, s.getPrecioServicio());
            state.setInt(3, s.getIdEmpleado());

            state.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el servicio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void eliminar(int idEmpleado) {

        Connection conexion = null;
        PreparedStatement state = null;
        try {
            conexion = SQL_Conexion.conectar();
            String consulta = "delete from servicio where idEmpleado = ?";
            state = conexion.prepareStatement(consulta);
            state.setInt(1, idEmpleado);
            state.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario no cuenta con servicios registrados: " + e);
        } 
    }

    @Override
    public List<Servicio> ListarServicios() {

        List<Servicio> lista_servicios = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM `servicio`";
            Connection conexion = SQL_Conexion.conectar();
            PreparedStatement state = conexion.prepareStatement(consulta);
            ResultSet resultado = state.executeQuery();
            while (resultado.next()) {
                int idServicio = resultado.getInt("idServicio");
                String nombreServicio = resultado.getString("nombreServicio");
                double precioServicio = resultado.getDouble("precio");
                int idEmpleado = resultado.getInt("idEmpleado");
                Servicio servicio = new Servicio(idServicio, nombreServicio, precioServicio, idEmpleado);
                lista_servicios.add(servicio);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Todavía no trabajadores registrados");
        }

        return lista_servicios;
    }

    @Override
    public List<Servicio> obtenerServicios(int idEmpleado) {

        List<Servicio> lista_servicios = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM `servicio` where idEmpleado = ?";
            Connection conexion = SQL_Conexion.conectar();
            PreparedStatement state = conexion.prepareStatement(consulta);
            state.setInt(1, idEmpleado);
            ResultSet resultado = state.executeQuery();
            while (resultado.next()) {
                int idServicio = resultado.getInt("idServicio");
                String nombreServicio = resultado.getString("nombreServicio");
                double precioServicio = resultado.getDouble("precio");
                Servicio servicio = new Servicio(idServicio, nombreServicio, precioServicio, idEmpleado);
                lista_servicios.add(servicio);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Todavía no trabajadores registrados");
        }

        return lista_servicios;

    }

}
