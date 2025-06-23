package repository;

import Clases.Empleado;
import database.ConexionBD;
import interfaces.IRepo.IRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository implements IRepository<Empleado, Integer> {

    private static final String SELECT_ALL = "SELECT * FROM empleado";
    private static final String SELECT_BY_ID = "SELECT * FROM empleado WHERE id = ?";
    private static final String INSERT_SQL = "INSERT INTO empleado(nombre, apellidos, username, password) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE empleado SET nombre = ?, apellidos = ?, username = ?, password = ?, status = ?, fecha_creado = ? WHERE id = ?";
    private static final String DESACTIVAR_SQL = "UPDATE empleado SET status = 'inactivo' WHERE id = ?";
    private static final String ACTIVAR_SQL = "UPDATE empleado SET status = 'activo' WHERE id = ?";

    @Override
    public List<Empleado> listar() throws Exception{
        List<Empleado> empleados = new ArrayList<>();
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                empleados.add(mapear(rs));
            }
        } catch (SQLException e) {
            throw e;
        }
        return empleados;
    }

    @Override
    public Empleado buscarPorId(Integer id) throws Exception{
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapear(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int crear(Empleado e)throws Exception {
        ResultSet rs = null;
        int idGenerado = -1;
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getUsername());
            ps.setString(4, e.getPassword());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw ex;
        }
        return idGenerado;
        
    }

    @Override
    public void actualizar(Empleado e)throws Exception {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_SQL)) {

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApellidos());
            ps.setString(3, e.getUsername());
            ps.setString(4, e.getPassword());
            ps.setInt(5, "activo".equalsIgnoreCase(e.getStatus()) ? 1:0);
            ps.setString(6, e.getFechaCreado());
            ps.setInt(7, e.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void desactivar(Integer id)throws Exception {
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(DESACTIVAR_SQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void activar(Integer id) throws Exception{
        try (Connection conn = ConexionBD.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(ACTIVAR_SQL)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
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
                rs.getString("status"),
                rs.getString("fecha_creado")
        );
    }
}
