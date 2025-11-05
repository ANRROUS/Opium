package ModeloDAO;

import Modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    
    void insertar(Cliente c);
    List<Cliente> listarCliente();
    Cliente obtenerCliente( int idCliente);
    
}
