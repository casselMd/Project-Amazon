package interfaces.IRepo;

import java.util.List;

public interface IProcesosRepository<T> {
    int crear(T t) throws Exception;
    List<T> listar() throws Exception;
    T buscarPorId(int id) throws Exception;
    
}
