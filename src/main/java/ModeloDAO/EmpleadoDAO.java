package ModeloDAO;

import Modelo.Empleado;
import java.util.List;

public interface EmpleadoDAO {
    
    void insertar(Empleado e);
    void eliminar(int idEmpleado);
    void actualizar(Empleado e);
    List<Empleado> listarEmpleado();
    Empleado obtenerEmpleado(int idEmpleado);
    
}
