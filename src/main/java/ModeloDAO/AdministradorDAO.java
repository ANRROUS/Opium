package ModeloDAO;

import Modelo.Administrador;
import java.util.List;

public interface AdministradorDAO {
    
    int iniciarSesion(String usuario, String password);
    void insertar(Administrador admin);
    void eliminar(int idAdministrador);
    void actualizar(Administrador admin);
    List<Administrador> listarAdministrador();
    Administrador obtenerAdministrador(int idAdministrador);
    
}
