package ModeloDAO;

import Modelo.Incidencia;
import java.util.List;

public interface IncidenciaDAO {
    
    void insertar(Incidencia i);
    void eliminar(int idIncidencia);
    List<Incidencia> listarIncidencia();
    
}
