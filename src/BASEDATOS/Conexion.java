
package BASEDATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    public static String url = "jdbc:mysql://localhost:3306/pasteleria_las_delicias";
    public static String user = "root";
    public static String password = "";
    
    public static Connection conectar() throws SQLException{
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(url, user, password);
           // System.out.println("Conexion exitosa.");
        } catch (SQLException e) {
            throw e;
        }
        return conexion;
    }
}
