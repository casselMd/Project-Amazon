package repository;

import Clases.Cliente;
import database.ConexionBD;
import interfaces.IRepo.IRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IRepository<Cliente , String> {
    private static final String SELECT_ALL = "SELECT * status FROM cliente";
    private static final String SELECT_BY_ID = "SELECT * FROM cliente WHERE id = ?";
    private static final String INSERT_SQL = "INSERT INTO cliente(id, cliente,direccion,telefono) VALUES (? ,?, ?)";
    private static final String UPDATE_SQL = "UPDATE cliente SET cliente = ?, direccion = ?, telefono = ?, status = ? WHERE id = ?";
    private static final String ACTIVAR_SQL = "UPDATE cliente SET status = 1 WHERE id = ?";
    private static final String DESACTIVAR_SQL = "UPDATE cliente SET status = 0 WHERE id = ?";

    @Override
    public List<Cliente> listar() throws Exception{
        List<Cliente> lista = new ArrayList<>();
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
    public Cliente buscarPorId(String id) throws Exception{
        Cliente cliente= null;
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente =  mapear(rs);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return cliente;
    }

    @Override
    public int crear(Cliente cliente)throws Exception {
        ResultSet rs = null;
        int idGenerado = -1;
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion()); 
            ps.setString(4, cliente.getTelefono()); 
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
    public void actualizar(Cliente cliente)throws Exception {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDireccion());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, "activo".equalsIgnoreCase(cliente.getStatus()) ? 1 : 0);
            ps.setString(5, cliente.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void desactivar(String id)throws Exception {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(DESACTIVAR_SQL)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void activar(String id) throws Exception{
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(ACTIVAR_SQL)) {
            ps.setString(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            throw e;
        }
    }

    private Cliente mapear(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getString("id"),
                rs.getString("cliente"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getBoolean("status") ? "activo" : "inactivo"
        );
    }
}
