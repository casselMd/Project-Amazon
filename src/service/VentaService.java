package service;

import Clases.Venta;
import interfaces.IRepo.IProcesosRepository;
import repository.VentaRepository;

import java.util.List;
import interfaces.IService.IProcesosService;

public class VentaService implements IProcesosService<Venta> {
    private final IProcesosRepository<Venta> repo;

    public VentaService() {
        this.repo = new VentaRepository();
    }

    @Override
    public int crear(Venta venta)throws Exception{
        return repo.crear(venta);
    }

    @Override
    public List<Venta> listar() throws Exception{
        return repo.listar();
    }

    @Override
    public Venta obtenerPorId(int id) throws Exception{
        return repo.buscarPorId(id);
    }
}
