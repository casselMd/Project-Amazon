package utils;
import org.mindrot.jbcrypt.BCrypt;
public class SeguridadUtils {

    public static String hashearPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verificarPassword(String passwordPlano, String passwordHasheado) {
        return BCrypt.checkpw(passwordPlano, passwordHasheado);
    }
}

