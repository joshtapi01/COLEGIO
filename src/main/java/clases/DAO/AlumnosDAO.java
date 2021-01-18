/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.DAO;

import clases.entity.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class AlumnosDAO {
    
    
    private String mensaje;
      
    public String agregarAlumno( Connection conn, Alumno al ){
        PreparedStatement pst = null;
        String sql = "insert into alumno (codigo_alumno, nombre_apellido, fecha_nac, grado, seccion, direccion, email, alcontraseña)" + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, al.getIdAlumno());
            pst.setString(2, al.getNombres());
            pst.setString(3, al.getFechaNac());
            pst.setString(4, al.getGrado());
            pst.setString(5, al.getSeccion());
            pst.setString(6, al.getDireccion());
            pst.setString(7, al.getEmail());
            pst.setString(8, al.getAlcontraseña());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();
           
        } catch (Exception e) 
        {
            mensaje = "NO SE GUARDADO CORRECTAMENTE" + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarAlumno(Connection conn, Alumno al){
         PreparedStatement pst = null;
        String sql = "UPDATE alumno set nombre_apellido = ?, fecha_nac = ?, grado = ?, seccion = ?, direccion = ?, email = ?, alcontraseña = ?" + "where codigo_alumno = ?";
        
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, al.getNombres());
            pst.setString(2, al.getFechaNac());
            pst.setString(3, al.getGrado() + "");
            pst.setString(4, al.getSeccion() + "");
            pst.setString(5, al.getDireccion());
            pst.setString(6, al.getEmail());
            pst.setString(7, al.getAlcontraseña());
            pst.setInt(8, al.getIdAlumno());
            mensaje = "MODIFICADO CORRECTAMENTE";
            pst.execute();
            pst.close();
           
        } catch (Exception e) 
        {
            mensaje = "NO SE MODIFICAR CORRECTAMENTE " + e.getMessage();
        }
        return mensaje;
     
    }
    public String eliminarAlumno(Connection conn, int id) {
        PreparedStatement pst = null;
        String sql = "delete from alumno where codigo_alumno = ?";
        
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();
           
        } catch (Exception e) 
        {
            mensaje = "NO SE ELIMINO CORRECTAMENTE" + e.getMessage();
        }
        
        return mensaje;
        
    }
    public void listarAlumno(Connection conn, JTable tabla) 
    {
        DefaultTableModel model; // llamamos a nuesta tabla //
        String [] columnas = {"Codigo", "Nombres y apellidos", "Fecha de nacimiento", "Grado", "Seccion", "Direccion", "Email", "Contraseña"}; // creamos nuestras columnas //
        model = new DefaultTableModel(null, columnas); // asigamos a nuestro modelo //
        
        String sql = "select codigo_alumno, nombre_apellido, TO_CHAR(fecha_nac,'DD/MM/YY'), grado, seccion, direccion, email, alcontraseña from alumno order by codigo_alumno"; // creamos nuestra secuencia SQL
        
        String[] filas = new String[8]; // creamos el Array de filas
        Statement st = null; // ejecutar el Query //
        ResultSet rs = null; // va obtener el resultaado //
        try 
        {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) { // recorrido
                for (int i = 0; i < 8; i++) { // guarda los datos en las filas
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas); // agregar filas //
            }
            tabla.setModel(model); // se guardan las filas
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
    
    public int getMaxID(Connection conn){
        int id = 0;
        PreparedStatement pst  = null;
        ResultSet rs = null;
        String sql = "select max(codigo_alumno) + 1 from alumno";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
                
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println("Errror al encontrar ID" + e.getMessage());
        }
        return id;
    }
    
    public void listarAlumnoN(Connection conn, JTable tabla) 
    {
        DefaultTableModel model; // llamamos a nuesta tabla //
        String [] columnas = {"Codigo", "Nombres y apellidos", "Grado", "Seccion"}; // creamos nuestras columnas //
        model = new DefaultTableModel(null, columnas); // asigamos a nuestro modelo //
        
        String sql = "select codigo_alumno, nombre_apellido, grado, seccion from alumno order by codigo_alumno"; // creamos nuestra secuencia SQL
        
        String[] filas = new String[4]; // creamos el Array de filas
        Statement st = null; // ejecutar el Query //
        ResultSet rs = null; // va obtener el resultaado //
        try 
        {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) { // recorrido
                for (int i = 0; i < 4; i++) { // guarda los datos en las filas
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas); // agregar filas //
            }
            tabla.setModel(model); // se guardan las filas
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
    
    
    
}

