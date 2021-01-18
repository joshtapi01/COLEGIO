/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.BO;

import clases.DAO.RevDocenteDAO;
import clases.co.bd.Conexion;
import clases.entity.RevDocente;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Jose
 */
public class RevDocenteBO {
    
    private String mensaje = "";
    
    private RevDocenteDAO revDao = new RevDocenteDAO();
    
    public String agregarRevDocente( RevDocente reDo ){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = revDao.agregarRevDocente(conn, reDo);
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
    
    public String modificarRevDocente( RevDocente reDo){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = revDao.modificarRevDocente(conn, reDo);
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
    
    public String eliminarRevDocente( int id) {
        Connection conn = Conexion.getConnection();
        try {
            mensaje = revDao.eliminarRevDocente(conn, id);
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
    
    public void listarRevDocente(JTable tabla) {
        Connection conn = Conexion.getConnection();
        revDao.listarRevDocente(conn, tabla);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection conn = Conexion.getConnection();
        int id = revDao.getMaxID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public void listarRevDocenteDo(JTable tabla, int codigo) {
        Connection conn = Conexion.getConnection();
        revDao.listarRevAlumnoAl(conn, tabla, codigo);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
}
