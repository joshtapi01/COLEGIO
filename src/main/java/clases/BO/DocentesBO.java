/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.BO;

import clases.DAO.DocentesDAO;
import clases.co.bd.Conexion;
import clases.entity.Docentes;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Jose
 */
public class DocentesBO {
    
    private String mensaje = "";
    
    private DocentesDAO doDao = new DocentesDAO();
    
    public String agregarDocente( Docentes doce ){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = doDao.agregarDocente(conn, doce);
        } catch (Exception e) 
        {
            mensaje = mensaje + " " + e.getMessage();         
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e)
            {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
        
    }
    
    public String modificarDocente( Docentes doce){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = doDao.modificarDocente(conn, doce);
        } catch (Exception e) 
        {
            mensaje = mensaje + " " + e.getMessage();         
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e)
            {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
        
    }
    public String eliminarDocente( int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = doDao.eliminarDocente(conn, id);
        } catch (Exception e) 
        {
            mensaje = mensaje + " " + e.getMessage();         
        }finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e)
            {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
        
    }
    
    public void listarDocente(JTable tabla) {
        Connection conn = Conexion.getConnection();
        doDao.listarDocente(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = doDao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
      
    
    
}
