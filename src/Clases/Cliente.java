package Clases;

public class Cliente {
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String status;

    public Cliente(){}

    public Cliente(String id, String nombre, String direccion, String telefono, String status) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.status = status;
    }

    public Cliente(String nombre, String direccion, String telefono, String status) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.status = status;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
