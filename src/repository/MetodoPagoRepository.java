package repository;

import Clases.MetodoPago;
import database.ConexionBD;
import interfaces.IRepo.IRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetodoPagoRepository implements IRepository<MetodoPago, Integer> {
    private static final String SELECT_ALL = "SELECT id, metodo_pago, status FROM metodo_pago";
    private static final String SELECT_BY_ID = "SELECT id, metodo_pago, status FROM metodo_pago WHERE id = ?";
    private static final String INSERT_SQL = "INSERT INTO metodo_pago(metodo_pago, status) VALUES (?, ?)";
    private static final String UPDATE_SQL = "UPDATE metodo_pago SET metodo_pago = ?, status = ? WHERE id = ?";
    private static final String ACTIVAR_SQL = "UPDATE metodo_pago SET status = 1 WHERE id = ?";
    private static final String DESACTIVAR_SQL = "UPDATE metodo_pago SET status = 0 WHERE id = ?";

    @Override
    public List<MetodoPago> listar() throws SQLException{
        List<MetodoPago> lista = new ArrayList<>();
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
    public MetodoPago buscarPorId(Integer id)throws SQLException {
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

    @Override
    public int crear(MetodoPago metodo)throws SQLException {
        ResultSet rs = null;
        int idGenerado = -1;
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, metodo.getNombre());
            ps.setInt(2, 1); // Activo por defecto
            ps.executeUpdate();
            
            rs= ps.getGeneratedKeys();
            if(rs.next()){
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return idGenerado;
    }

    @Override
    public void actualizar(MetodoPago metodo)throws SQLException {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, metodo.getNombre());
            ps.setInt(2, "activo".equalsIgnoreCase(metodo.getStatus()) ? 1 : 0);
            ps.setInt(3, metodo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void desactivar(Integer id)throws SQLException {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(DESACTIVAR_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void activar(Integer id)throws SQLException {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(ACTIVAR_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    private MetodoPago mapear(ResultSet rs) throws SQLException {
        return new MetodoPago(
                rs.getInt("id"),
                rs.getString("metodo_pago"),
                rs.getBoolean("status") ? "activo" : "inactivo"
        );
    }
}
