/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.BO;

import clases.DAO.AlumnosDAO;
import clases.co.bd.Conexion;
import clases.entity.Alumno;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Jose
 */
public class AlumnoBO {
    
    private String mensaje = "";
    private AlumnosDAO adao = new AlumnosDAO();
    
    public String agregarAlumno( Alumno al ){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = adao.agregarAlumno(conn, al);
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
    
    public String modificarAlumno( Alumno al){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = adao.modificarAlumno(conn, al);
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
    public String eliminarAlumno( int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = adao.eliminarAlumno(conn, id);
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
    public void listarAlumno(JTable tabla) {
        Connection conn = Conexion.getConnection();
        adao.listarAlumno(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void listarAlumnoN(JTable tabla) {
        Connection conn = Conexion.getConnection();
        adao.listarAlumnoN(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = adao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
}
