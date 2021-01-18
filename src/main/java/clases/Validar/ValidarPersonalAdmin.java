/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Validar;

import clases.co.bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jose
 */
public class ValidarPersonalAdmin {
    
    public boolean validarUsuario(String xcod, String xcla){
        try{
            Connection conn = Conexion.getConnection();
            String sql = "select count(*) from administrador where codigo_administrador=? AND " + "adcontraseña=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, xcod);
            ps.setString(2, xcla);
            ResultSet rs = ps.executeQuery();
             rs.next();
            String cantidad = rs.getString(1);
            int xcant = Integer.parseInt(cantidad);
            if (xcant > 0){
                return true;}
            conn.close();
            return false;
        }catch (Exception ex){
            System.out.println(ex.toString());
            
        }
        return false;

    } 
}
