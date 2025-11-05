package ModeloDAO;

import Modelo.Recibo;
import java.util.List;

public interface ReciboDAO {
    
    void insertar(Recibo r);
    void modificar(Recibo r);
    void eliminar(int idRecibo);
    List<Recibo> listarRecibo();
    List<Recibo> listarReciboDia(int Day);
    Recibo obtenerRecibo(int idRecibo);
    
}
