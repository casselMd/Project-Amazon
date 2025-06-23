package repository;

import Clases.*;
import database.ConexionBD;
import interfaces.IRepo.IProcesosRepository;
import interfaces.IService.IService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import service.ClienteService;
import service.MetodoPagoService;
import services.EmpleadoService;

public class VentaRepository implements IProcesosRepository<Venta> {
    private final IService<Cliente, String> clienteServ;
    private final IService<Empleado, Integer> empleadoServ;
    private final IService<MetodoPago, Integer> pagoServ;
    private final DetalleVentaRepository dRepo ;
    public VentaRepository(){
        this.clienteServ = new ClienteService();
        this.empleadoServ =  new EmpleadoService();
        this.pagoServ =  new MetodoPagoService();
        dRepo = new DetalleVentaRepository();
        
    }
    @Override
    public int crear(Venta venta) throws Exception{
        int idGenerado = -1;
        String sql = "INSERT INTO venta(empleado_id, total, metodo_pago_id, cliente_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, venta.getEmpleado().getId());
            ps.setDouble(2, venta.getTotal());
            ps.setInt(3, venta.getMetodoPago().getId());
            ps.setString(4, venta.getCliente().getId());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                    for (DetalleVenta d : venta.getDetalleVentas()) {
                        this.dRepo.crear(d, idGenerado);
                    }
                    return idGenerado;
                }
            }

        } catch (SQLException e) {
            throw e;
        }
        return idGenerado;
    }

    @Override
    public List<Venta> listar() throws Exception{
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM venta";
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Venta v = new Venta();
                v.setId(rs.getInt("id"));
                v.setFecha(rs.getDate("fecha"));
                v.setTotal(rs.getDouble("total"));
                v.setCliente(clienteServ.obtenerPorId(rs.getString("cliente_id")));
                v.setEmpleado(empleadoServ.obtenerPorId(rs.getInt("empleado_id")));
                v.setMetodoPago(pagoServ.obtenerPorId(rs.getInt("metodo_pago_id")));
                lista.add(v);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    @Override
    public Venta buscarPorId(int id) throws Exception{
        Venta venta = null;
        String sql = "SELECT * FROM venta  WHERE id = ?";
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    venta = new Venta();
                    venta.setId(rs.getInt("id"));
                    venta.setFecha(rs.getDate("fecha"));
                    venta.setTotal(rs.getDouble("total"));
                    venta.setCliente(clienteServ.obtenerPorId(rs.getString("cliente_id")));
                    venta.setEmpleado(empleadoServ.obtenerPorId(rs.getInt("empleado_id")));
                    venta.setMetodoPago(pagoServ.obtenerPorId(rs.getInt("metodo_pago_id")));
                    venta.setDetalleVentas(new ArrayList(dRepo.listar(id)));
                }
            }
            
            
            
        } catch (SQLException e) {
            throw e;
        }
        return venta;
    }
}
