package Clases;

public class Empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private String username;
    private String password;
    private String dni;
    private String rol;
    private String status;
    private String fechaCreado;

    public Empleado() {}

    public Empleado(int id, String nombre, String apellidos, String username, String password, String dni, String rol, String status, String fechaCreado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.rol = rol;
        this.status = status;
        this.fechaCreado = fechaCreado;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(String fechaCreado) {
        this.fechaCreado = fechaCreado;
    }
}
