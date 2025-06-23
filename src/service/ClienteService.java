package service;

import Clases.Cliente;
import interfaces.IRepo.IRepository;
import interfaces.IService.IService;
import repository.ClienteRepository;

import java.util.List;

public class ClienteService implements IService<Cliente,String> {
    private final IRepository<Cliente, String> repo;

    public ClienteService() {
        this.repo = new ClienteRepository();
    }

    @Override
    public List<Cliente> listar() throws Exception{
        return repo.listar();
    }

    @Override
    public Cliente obtenerPorId(String id)throws Exception {
       return repo.buscarPorId(id);
    }

    @Override
    public int crear(Cliente cliente)throws Exception {
        return repo.crear(cliente);
    }

    @Override
    public void actualizar(Cliente cliente) throws Exception{
        repo.actualizar(cliente);
    }

    @Override
    public void desactivar(String id) throws Exception{
         repo.desactivar(id);
    }

    @Override
    public void activar(String id)throws Exception {
         repo.activar(id);
    }
}
