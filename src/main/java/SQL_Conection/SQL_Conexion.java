package SQL_Conection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQL_Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/OpiumBD";
    private static final String USER = "root";
    private static final String password = "";
    
    public static Connection conectar(){
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, password);
        } catch (Exception e) {
            System.out.println("Ocurrió un problema"+e.getMessage());
        }
        return conexion;
    }
}
