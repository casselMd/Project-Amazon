package interfaces.IService;
import java.util.List;

public interface IService<Clase, TipoDato> {
    List<Clase> listar() throws Exception;
    Clase obtenerPorId(TipoDato id) throws Exception;
    int crear(Clase clase) throws Exception;
    void actualizar(Clase clase) throws Exception;
    void desactivar(TipoDato id) throws Exception;
    void activar(TipoDato id) throws Exception;
}
