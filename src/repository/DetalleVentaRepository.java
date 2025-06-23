package repository;

import Clases.DetalleVenta;
import database.ConexionBD;
import interfaces.IRepo.IDetalleRepository;
import interfaces.IService.IService;
import Clases.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import service.ProductoService;

public class DetalleVentaRepository implements IDetalleRepository<DetalleVenta> {
    private final IService<Producto,Integer> prodServ;
    
    public DetalleVentaRepository(){
        this.prodServ =  new ProductoService();
    }

    @Override
    public int crear(DetalleVenta detalle, int idVenta) throws Exception{
        ResultSet rs = null;
        int idGenerado = -1;
        String sql = "INSERT INTO detalle_venta(venta_id, producto_id, cantidad, precio_unitario,subtotal) VALUES (?, ?, ?, ?,?)";
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, idVenta);
            ps.setInt(2, detalle.getProducto().getId());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnitario());
            detalle.calcularSubtotal();
            ps.setDouble(5, detalle.getSubtotal());
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
    public List<DetalleVenta> listar(int idVenta)throws Exception {
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_venta WHERE venta_id = ?";
        try (Connection conn = ConexionBD.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVenta);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetalleVenta d = new DetalleVenta();
                    d.setId(rs.getInt("id"));
                    d.setCantidad(rs.getInt("cantidad"));
                    d.setPrecioUnitario(rs.getDouble("precio_unitario"));
                    d.setProducto(prodServ.obtenerPorId(rs.getInt("producto_id")));
                    lista.add(d);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

   

    

    
}
