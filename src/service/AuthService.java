package service;
import Clases.Empleado;
import interfaces.IRepo.IAuthRepository;
import interfaces.IService.IAuthService;
import repository.AuthRepository;
import utils.SeguridadUtils;

public class AuthService implements IAuthService {
    private final IAuthRepository authRepo;
    
    public  AuthService(){
        this.authRepo = new AuthRepository();
    }
    
    @Override
    public boolean autenticarUsuario(String nombreUsuario, String pass, String rol){
        Empleado emp = this.authRepo.autenticar(nombreUsuario, pass, rol);
        if(SeguridadUtils.verificarPassword(pass, emp.getPassword())) return true;
        return false;
    }
}
