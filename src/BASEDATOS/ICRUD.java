package BASEDATOS;

import java.sql.SQLException;
import java.util.ArrayList;


public interface ICRUD<T> {
    
    public ArrayList listar() throws Exception;
    public int crear(T object) throws SQLException;
    public void actualizar(int id, T object) throws Exception;   
    public void eliminar(int id)throws Exception;
    public T obtener(int id)throws Exception;
}
