package services;

import Clases.Empleado;
import interfaces.IRepo.IRepository;
import interfaces.IService.IService;
import repository.EmpleadoRepository;
import utils.SeguridadUtils;

import java.util.List;

public class EmpleadoService implements IService<Empleado, Integer> {

    private final IRepository<Empleado, Integer> repo;

    public EmpleadoService() {
        this.repo = new EmpleadoRepository();
    }

    @Override
    public List<Empleado> listar() throws Exception{
        return repo.listar();
    }

    @Override
    public Empleado obtenerPorId(Integer id)  throws Exception{
        return repo.buscarPorId(id);
    }

    @Override
    public int crear(Empleado empleado) throws Exception {
        return repo.crear(empleado);
    }

    @Override
    public void actualizar(Empleado empleado)  throws Exception{
        repo.actualizar(empleado);
    }

    @Override
    public void desactivar(Integer id) throws Exception {
         repo.desactivar(id);
    }

    @Override
    public void activar(Integer id)  throws Exception{
         repo.activar(id);
    }
}
