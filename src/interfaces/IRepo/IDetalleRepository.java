package interfaces.IRepo;
import java.util.List;

public interface IDetalleRepository<T> {
    int crear(T detalle, int id)throws Exception;
    List<T> listar(int idVenta) throws Exception;
}
