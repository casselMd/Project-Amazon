package BASEDATOS;


import org.mindrot.jbcrypt.BCrypt;

public class Seguridad {
    
    public static String hashearContraseña(String textoPlano) {
        return BCrypt.hashpw(textoPlano, BCrypt.gensalt(12));
    }

    public static boolean verificarContraseña(String textoPlano, String hash) {
        return BCrypt.checkpw(textoPlano, hash);
    }
}
