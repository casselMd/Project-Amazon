package Clases;

import java.sql.Date;
import java.util.ArrayList;

public class Venta {
    private int id;
    private Empleado empleado;
    private Date fecha;
    private double total;
    private MetodoPago metodoPago;
    private Cliente cliente;
    private ArrayList<DetalleVenta> detalleVentas;

    public Venta() {}

    public Venta(int id, Empleado empleado, Date fecha, double total, MetodoPago metodoPago, Cliente cliente, ArrayList<DetalleVenta> detalleVentas) {
        this.id = id;
        this.empleado = empleado;
        this.fecha = fecha;
        this.total = total;
        this.metodoPago = metodoPago;
        this.cliente = cliente;
        this.detalleVentas = detalleVentas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<DetalleVenta> getDetalleVentas() {
        return detalleVentas;
    }

    public void setDetalleVentas(ArrayList<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }
}
