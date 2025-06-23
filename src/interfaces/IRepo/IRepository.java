package interfaces.IRepo;

import java.util.ArrayList;
import java.util.List;

public interface IRepository<Clase, TipoDatoId> {

    List<Clase> listar() throws Exception;
    Clase buscarPorId(TipoDatoId id) throws Exception;
    int crear(Clase objeto) throws Exception;
    void actualizar(Clase objeto) throws Exception;
    void desactivar(TipoDatoId id) throws Exception;
    void activar(TipoDatoId id) throws Exception;


}
