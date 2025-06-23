package interfaces.IService;

import java.util.List;

public interface IProcesosService <Clase>  {
    int crear(Clase clase) throws Exception;
    List<Clase> listar() throws Exception;
    Clase obtenerPorId(int id)throws Exception;
}
