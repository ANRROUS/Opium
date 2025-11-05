package ModeloDAO;

import Modelo.Pago;
import java.util.List;

public interface PagoDAO {
    
    void insertar(Pago p);
    List<Pago> listarPago();
    List<Pago> obtenerPago(String fechaRecibo);
    
}
