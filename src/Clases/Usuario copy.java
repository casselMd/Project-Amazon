
package Entidades;

public class Usuario {
     private int id;
    private String usuario;
    private String claveHash; // 🔐 Aquí se almacena la contraseña encriptada

    public Usuario() {
    }

    public Usuario(String usuario, String claveHash) {
        this.usuario = usuario;
        this.claveHash = claveHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClaveHash() {
        return claveHash;
    }

    public void setClaveHash(String claveHash) {
        this.claveHash = claveHash;
    }
    
}
