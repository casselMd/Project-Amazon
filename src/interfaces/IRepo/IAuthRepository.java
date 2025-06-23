/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.IRepo;

import Clases.Empleado;

/**
 *
 * @author JHONATAN
 */
public interface IAuthRepository {
    
    Empleado autenticar(String username, String pass, String rol);
    
}
