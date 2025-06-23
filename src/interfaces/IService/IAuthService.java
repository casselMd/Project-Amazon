/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.IService;

/**
 *
 * @author JHONATAN
 */
public interface IAuthService {
    boolean autenticarUsuario(String nombreUsuario, String pass, String rol);
    
}
