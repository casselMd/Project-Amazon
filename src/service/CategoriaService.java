package service;

import Clases.Categoria;
import interfaces.IRepo.IRepository;
import interfaces.IService.IService;

import java.util.List;
import repository.CategoriaRepository;

public class CategoriaService implements IService<Categoria, Integer> {
    private final IRepository<Categoria,Integer> repo;

    public CategoriaService() {
        this.repo = new CategoriaRepository();
    }

    public List<Categoria> listar() throws Exception{
        return repo.listar();
    }

    public Categoria obtenerPorId(Integer id)throws Exception{
        return  repo.buscarPorId(id);
    }

    public int crear(Categoria categoria)throws Exception {
        return repo.crear(categoria);
    }

    public void actualizar(Categoria categoria)throws Exception {
        repo.actualizar(categoria);
    }

    public void desactivar(Integer id) throws Exception{
        repo.desactivar(id);
    }
    public void activar(Integer id)throws Exception {
        repo.activar(id);
    }

    
}