/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.DAO;

import clases.entity.Calificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class CalificacionesDAO {
    
    private String mensaje;

    public String agregarCalificacion(Connection conn, Calificacion ca) {
        PreparedStatement pst = null;
        String sql = "insert into calificacion (codigo_calificacion, nota_final, curso_calificar, codigo_docente, codigo_alumno)" + "values(?, ?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, ca.getIdNota());
            pst.setInt(2, ca.getNota_final());
            pst.setString(3, ca.getCurso());
            pst.setInt(4, ca.getIdDocente());
            pst.setInt(5, ca.getIdAlumno());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        } catch (Exception e) {
            mensaje = "NO SE GUARDADO CORRECTAMENTE" + e.getMessage();
        }
        return mensaje;
    }
    
     public String modificarCalificacion(Connection conn, Calificacion ca) {
        PreparedStatement pst = null;
        String sql = "UPDATE calificacion set nota_final = ?, curso_calificar = ?, codigo_docente = ?, codigo_alumno = ?" + "where codigo_calificacion = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, ca.getNota_final());
            pst.setString(2, ca.getCurso());
            pst.setInt(3, ca.getIdDocente());
            pst.setInt(4, ca.getIdAlumno());
            pst.setInt(5, ca.getIdNota());
            mensaje = "MODIFICADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        } catch (Exception e) {
            mensaje = "NO SE MODIFICAR CORRECTAMENTE " + e.getMessage();
        }
        return mensaje;

    }
     
     public String eliminarCalificacion(Connection conn, int id) {
        PreparedStatement pst = null;
        String sql = "delete from calificacion where codigo_calificacion = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            mensaje = "ELIMINADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        } catch (Exception e) {
            mensaje = "NO SE ELIMINO CORRECTAMENTE" + e.getMessage();
        }

        return mensaje;

    }
     
    public void listarCalificacion(Connection conn, JTable tabla, int codigo) {
        DefaultTableModel model; // llamamos a nuesta tabla //
        String[] columnas = {"Codigo Calificacion", "Nota Final", "Curso", "Codigo Alumno","Nombre","Grado","Seccion"}; // creamos nuestras columnas //
        model = new DefaultTableModel(null, columnas); // asigamos a nuestro modelo //

        String sql = "select codigo_calificacion, nota_final, curso_calificar, codigo_alumno, nombre_apellido, grado, seccion\n" +
                        "from calificacion \n" +
                        "natural join alumno \n" +
                        "where codigo_docente = " + codigo +
                        "order by codigo_calificacion"; // creamos nuestra secuencia SQL

        String[] filas = new String[7]; // creamos el Array de filas
        Statement st = null; // ejecutar el Query //
        ResultSet rs = null; // va obtener el resultaado //
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) { // recorrido
                for (int i = 0; i < 7; i++) { // guarda los datos en las filas
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas); // agregar filas //
            }
            tabla.setModel(model); // se guardan las filas
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
    
    public void Calificaciones(Connection conn, JTable tabla, int codigo) {
        DefaultTableModel model; // llamamos a nuesta tabla //
        String[] columnas = {"Curso", "Nota Final"}; // creamos nuestras columnas //
        model = new DefaultTableModel(null, columnas); // asigamos a nuestro modelo //

        String sql = "select Curso_calificar, nota_final\n" +
        "from calificacion\n" +
        "where codigo_alumno = 33311\n" +
        "order by curso_calificar"; // creamos nuestra secuencia SQL

        String[] filas = new String[2]; // creamos el Array de filas
        Statement st = null; // ejecutar el Query //
        ResultSet rs = null; // va obtener el resultaado //
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) { // recorrido
                for (int i = 0; i < 2; i++) { // guarda los datos en las filas
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas); // agregar filas //
            }
            tabla.setModel(model); // se guardan las filas
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla" + e.getMessage());
        }
    }
    
    public int getMaxID(Connection conn) {
        int id = 0;
        PreparedStatement pst  = null;
        ResultSet rs = null;
        String sql = "select max(codigo_calificacion) + 1 from calificacion";
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
     
}
