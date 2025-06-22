package BDGestion;

import BASEDATOS.Conexion;
import BASEDATOS.ICRUD;
import BASEDATOS.Seguridad;
import Entidades.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionUsuario implements ICRUD<Usuario> {
    
      public boolean crearUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario (usuario, clave) VALUES (?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Cifrar la contraseña ANTES de insertarla
            String hash = Seguridad.hashearContraseña(usuario.getClaveHash());
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, hash);

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }
     
    public Usuario validarLogin(String usuario, String claveIngresada, String rol) throws Exception {
    String sql = "SELECT * FROM usuario as u "
            + " inner join rol as r on u.id_tipo_rol = r.idRol "
            + " WHERE usuario = ? and nombreRol= ? ";

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, usuario);
        ps.setString(2, rol);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String hashBD = rs.getString("clave");

                // Validar la contraseña usando bcrypt
                if (Seguridad.verificarContraseña(claveIngresada, hashBD)) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setUsuario(usuario);
                    u.setClaveHash(hashBD); // opcional
                    return u;
                }
            }
        }
    } catch (SQLException e) {
        throw new Exception("Error al validar login: " + e.getMessage());
    }
    return null; // usuario no encontrado o contraseña incorrecta
    }

    @Override
    public ArrayList listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int crear(Usuario object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(int id, Usuario object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
