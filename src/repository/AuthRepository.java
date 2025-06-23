
package repository;

import Clases.Empleado;
import database.ConexionBD;
import interfaces.IRepo.IAuthRepository;
import java.sql.*;


public class AuthRepository implements IAuthRepository {
    
    private static final String SQL = "SELECT * FROM empleado where username = ? and rol = ?  and status = 1";
    
    public Empleado autenticar(String username, String pass, String rol){
        try(Connection conn = ConexionBD.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL)){
           // System.out.println("autenticando repo: "+ pass);
            ps.setString(1, username);
            ps.setString(2, rol);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    private Empleado mapear(ResultSet rs) throws SQLException {
        return new Empleado(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellidos"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("dni"),
                rs.getString("rol"),
                rs.getBoolean("status") ? "activo" : "inactivo",
                rs.getString("fecha_creado")
        );
    }
}
