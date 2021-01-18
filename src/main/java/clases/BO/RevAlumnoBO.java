/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.BO;

import clases.DAO.RevAlumnoDAO;
import clases.co.bd.Conexion;
import clases.entity.RevAlumno;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Jose
 */
public class RevAlumnoBO {
    
    private String mensaje = "";
    
    private RevAlumnoDAO revaDao = new RevAlumnoDAO();
    
    public String agregarRevAlumno( RevAlumno reAl ){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = revaDao.agregarRevAlumno(conn, reAl);
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
    
    public String modificarRevAlumno( RevAlumno reAl){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = revaDao.modificarRevAlumno(conn, reAl);
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
    
    public String eliminarRevAlumno( int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = revaDao.eliminarRevAlumno(conn, id);
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
    
    public void listarRevAlumno(JTable tabla) {
        Connection conn = Conexion.getConnection();
        revaDao.listarRevAlumno(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = revaDao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public void listarRevAlumnoAl(JTable tabla, int codigo) {
        Connection conn = Conexion.getConnection();
        revaDao.listarRevDocenteDo(conn, tabla, codigo);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
