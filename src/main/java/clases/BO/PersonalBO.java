/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.BO;

import clases.DAO.PersonalDAO;
import clases.co.bd.Conexion;
import clases.entity.PersonalAdmin;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Jose
 */
public class PersonalBO {
    
    private String mensaje = "";
    
    private PersonalDAO perDao = new PersonalDAO();
    
    public String agregarPersonalA( PersonalAdmin per ){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = perDao.agregarPersonalA(conn, per);
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
    
    public String modificarPersonalA( PersonalAdmin per){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = perDao.modificarPersonalA(conn, per);
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
    
    public String eliminarPersonalA( int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = perDao.eliminarPersonalA(conn, id);
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
    
    public void listarPersonalA(JTable tabla) {
        Connection conn = Conexion.getConnection();
        perDao.listarPersonalA(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = perDao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
}
