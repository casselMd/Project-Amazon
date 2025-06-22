package BDGestion;

import BASEDATOS.Conexion;
import BASEDATOS.ICRUD;
import Entidades.TipoRol;
import java.sql.*;
import java.util.ArrayList;

public class BDcomboTipoRol implements ICRUD<TipoRol>{

    @Override
    public ArrayList listar() throws Exception {
            ArrayList arrTR = new ArrayList();
    String sql = "SELECT * FROM rol";
    
    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ){
        while (rs.next()) {
            TipoRol objTP = new TipoRol();
            objTP.setId(rs.getInt("idRol"));
            objTP.setNombre(rs.getString("nombreRol"));
            arrTR.add(objTP);
        }
    } catch (Exception e) {
        throw e;
    }
    return arrTR;
    }

    
    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public int crear(TipoRol object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(int id, TipoRol object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoRol obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
