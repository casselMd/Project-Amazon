package service;

import Clases.MetodoPago;
import interfaces.IRepo.IRepository;
import interfaces.IService.IService;
import repository.MetodoPagoRepository;

import java.util.List;

public class MetodoPagoService implements IService<MetodoPago, Integer> {
    private final IRepository<MetodoPago, Integer> repo;

    public MetodoPagoService() {
        this.repo = new MetodoPagoRepository();
    }

    @Override
    public List<MetodoPago> listar()throws Exception{
        return repo.listar();
    }

    @Override
    public MetodoPago obtenerPorId(Integer id)throws Exception {
        return repo.buscarPorId(id);
    }

    @Override
    public int crear(MetodoPago m)throws Exception {
        return repo.crear(m);
    }

    @Override
    public void actualizar(MetodoPago m) throws Exception{
         repo.actualizar(m);
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

