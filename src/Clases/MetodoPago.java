package Clases;

public class MetodoPago {
    private int id;
    private String nombre;
    private String status;

    public MetodoPago() {}

    public MetodoPago(int id, String nombre, String status) {
        this.id = id;
        this.nombre = nombre;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

