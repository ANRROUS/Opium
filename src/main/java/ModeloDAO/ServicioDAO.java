package ModeloDAO;

import Modelo.Servicio;
import java.util.List;

public interface ServicioDAO {
    
    void insertar(Servicio s);
    void eliminar(int idEmpleado);
    List<Servicio> ListarServicios();
    List<Servicio> obtenerServicios(int idEmpleado);

}
