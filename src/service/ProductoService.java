package service;

import Clases.Categoria;
import Clases.Producto;
import interfaces.IRepo.IRepository;
import interfaces.IService.IService;
import repository.ProductoRepository;

import java.util.List;

public class ProductoService implements IService<Producto, Integer> {
    private final IRepository<Producto, Integer> repo;
    private final IService<Categoria, Integer> categoriaService;

    public ProductoService() {
        this.repo = new ProductoRepository();
        this.categoriaService = new CategoriaService();
    }

    @Override
    public List<Producto> listar()throws Exception{
        return repo.listar();
    }

    @Override
    public Producto obtenerPorId(Integer id)throws Exception {
        return repo.buscarPorId(id);
    }

    @Override
    public int crear(Producto producto) throws Exception{
        return repo.crear(producto);
    }

    @Override
    public void actualizar(Producto producto)throws Exception {
         repo.actualizar(producto);
    }

    @Override
    public void desactivar(Integer id) throws Exception{
        repo.desactivar(id);
    }

    @Override
    public void activar(Integer id) throws Exception{
        repo.activar(id);
    }
}
