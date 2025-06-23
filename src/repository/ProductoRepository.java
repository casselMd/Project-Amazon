package repository;

import Clases.Categoria;
import Clases.Producto;
import database.ConexionBD;
import interfaces.IRepo.IRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepository implements IRepository<Producto, Integer> {

    private static final String SELECT_ALL = "SELECT p.*, c.id AS cat_id, c.categoria, c.descripcion, c.status AS cat_status FROM producto p JOIN categoria c ON p.id_categoria = c.id";
    private static final String SELECT_BY_ID = "SELECT p.*, c.id AS cat_id, c.categoria, c.descripcion, c.status AS cat_status FROM producto p JOIN categoria c ON p.id_categoria = c.id WHERE p.id = ?";
    private static final String INSERT_SQL = "INSERT INTO producto(nombre, descripcion, precio,id_categoria) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ?, status = ?, id_categoria = ? WHERE id = ?";
    private static final String DESACTIVAR_SQL = "UPDATE producto SET status = 0 WHERE id = ?";
    private static final String ACTIVAR_SQL = "UPDATE producto SET status = 1 WHERE id = ?";

    @Override
    public List<Producto> listar() throws Exception{
        List<Producto> lista = new ArrayList<>();
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
    public Producto buscarPorId(Integer id) throws Exception{
        try {
            Connection conn = ConexionBD.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapear(rs);
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    @Override
    public int crear(Producto p) throws Exception{
        ResultSet rs = null;
        int idGenerado = -1;
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
            //ps.setInt(4, p.getStock());
            ps.setInt(4, p.getCategoria().getId());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return  idGenerado;
    }

    @Override
    public void actualizar(Producto p) throws Exception{
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getPrecio());
           // ps.setInt(4, p.getStock());
            ps.setInt(4, "activo".equalsIgnoreCase(p.getStatus()) ? 1 : 0);
            ps.setInt(5, p.getCategoria().getId());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void desactivar(Integer id) throws Exception{
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(DESACTIVAR_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void activar(Integer id)throws Exception {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(ACTIVAR_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    private Producto mapear(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria(
                rs.getInt("cat_id"),
                rs.getString("categoria"),
                rs.getString("descripcion"),
                rs.getBoolean("cat_status") ? "activo" : "inactivo"
        );
        return new Producto(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("descripcion"),
                rs.getDouble("precio"),
                //rs.getInt("stock"),
                rs.getBoolean("status")? "activo":"inactivo",
                categoria
        );
    }
}
