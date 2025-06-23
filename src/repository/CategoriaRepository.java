package repository;

import Clases.Categoria;
import database.ConexionBD;
import interfaces.IRepo.IRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository  implements IRepository<Categoria, Integer> {
    private final String SELECT_ALL    = "SELECT id, categoria, descripcion, status FROM categoria";
    private final String SELECT_BY_ID  = "SELECT id, categoria, descripcion, status FROM categoria WHERE id = ?";
    private final String INSERT_SQL    = "INSERT INTO categoria(categoria, descripcion, status) VALUES(?, ?, ?)";
    private final String UPDATE_SQL    = "UPDATE categoria SET categoria = ?, descripcion = ?, status = ? WHERE id = ?";
    private final String ACTIVAR_SQL    = "UPDATE categoria set status = 1 WHERE id = ?";
    private final String DESACTIVAR_SQL    = "UPDATE categoria set status = 0 WHERE id = ?";

    public List<Categoria> listar()  throws Exception{
        List<Categoria> lista = new ArrayList<>();
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer id)  throws Exception{
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public int crear(Categoria categoria) throws Exception {
        ResultSet rs =null;
        int idGenerado = -1;
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, 1);
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                idGenerado = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            throw e;
        }
        return idGenerado;
    }
    @Override
    public void actualizar(Categoria categoria) throws Exception {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, "activo".equalsIgnoreCase(categoria.getStatus()) ? 1 : 0 ); ;
            ps.setInt(4, categoria.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    @Override
    public void desactivar(Integer id) throws Exception {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(DESACTIVAR_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void activar(Integer id)  throws Exception{
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(ACTIVAR_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    private Categoria mapear(ResultSet rs) throws SQLException {
        return new Categoria(
                rs.getInt("id"),
                rs.getString("categoria"),
                rs.getString("descripcion"),
                rs.getBoolean("status") ? "activo" : "inactivo"
        );
    }

}