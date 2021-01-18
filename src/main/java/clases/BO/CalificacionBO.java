/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.BO;

import clases.DAO.CalificacionesDAO;
import clases.co.bd.Conexion;
import clases.entity.Calificacion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Jose
 */
public class CalificacionBO {
    
    private String mensaje = "";
    
    private CalificacionesDAO caDao = new CalificacionesDAO();
    
    public String agregarCalificacion( Calificacion ca ){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = caDao.agregarCalificacion(conn, ca);
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
    
    public String modificarCalificacion( Calificacion ca){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = caDao.modificarCalificacion(conn, ca);
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
    
    public String eliminarCalificacion( int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = caDao.eliminarCalificacion(conn, id);
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
    
    public void listarCalificacion(JTable tabla, int codigo) {
        Connection conn = Conexion.getConnection();
        caDao.listarCalificacion(conn, tabla, codigo);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void Calificaciones(JTable tabla, int codigo) {
        Connection conn = Conexion.getConnection();
        caDao.Calificaciones(conn, tabla, codigo);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = caDao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
}
