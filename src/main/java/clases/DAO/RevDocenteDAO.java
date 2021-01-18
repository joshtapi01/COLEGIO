/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.DAO;

import clases.entity.RevDocente;
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
public class RevDocenteDAO {
    
     private String mensaje;
    
    public String agregarRevDocente(Connection conn, RevDocente rDo) {
        PreparedStatement pst = null;
        String sql = "insert into revdocente (codigo_revision, codigo_administrador, codigo_docente, fecha_revicion, contrato)" + "values(?, ?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, rDo.getIdRevision());
            pst.setInt(2, rDo.getIdAdministrador());
            pst.setInt(3, rDo.getIdDocente());
            pst.setString(4, rDo.getFechaRevicion());
            pst.setString(5, rDo.getContrato());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        } catch (Exception e) {
            mensaje = "NO SE GUARDADO CORRECTAMENTE" + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarRevDocente(Connection conn, RevDocente rDo){
         PreparedStatement pst = null;
        String sql = "UPDATE revdocente set codigo_administrador = ?, codigo_docente = ?, fecha_revicion = ?, contrato = ?" + "where codigo_revision = ?";
        
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, rDo.getIdAdministrador());
            pst.setInt(2, rDo.getIdDocente());
            pst.setString(3, rDo.getFechaRevicion());
            pst.setString(4, rDo.getContrato());
            pst.setInt(5, rDo.getIdRevision());
            mensaje = "MODIFICADO CORRECTAMENTE";
            pst.execute();
            pst.close();
           
        } catch (Exception e) 
        {
            mensaje = "NO SE MODIFICO CORRECTAMENTE " + e.getMessage();
        }
        return mensaje;
     
    }
    
    public String eliminarRevDocente(Connection conn, int id) {
        PreparedStatement pst = null;
        String sql = "delete from revdocente where codigo_revision = ?";
        
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
    
    public void listarRevDocente(Connection conn, JTable tabla) {
        DefaultTableModel model; // llamamos a nuesta tabla //
        String[] columnas = {"Codigo de revision", "Codigo de Administrador", "Codigo Docente", "Fecha Revision", "Contrato"}; // creamos nuestras columnas //
        model = new DefaultTableModel(null, columnas); // asigamos a nuestro modelo //

        String sql = "select codigo_revision, codigo_administrador, codigo_docente, TO_CHAR(fecha_revision,'DD/MM/YY'), contrato from revdocente order by codigo_revision"; // creamos nuestra secuencia SQL

        String[] filas = new String[5]; // creamos el Array de filas
        Statement st = null; // ejecutar el Query //
        ResultSet rs = null; // va obtener el resultaado //
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) { // recorrido
                for (int i = 0; i < 5; i++) { // guarda los datos en las filas
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas); // agregar filas //
            }
            tabla.setModel(model); // se guardan las filas
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }

    public int getMaxID(Connection conn) {
        int id = 0;
        PreparedStatement pst  = null;
        ResultSet rs = null;
        String sql = "select max(codigo_revision) + 1 from revdocente";
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
    
    public void listarRevAlumnoAl(Connection conn, JTable tabla, int codigo) {
        DefaultTableModel model; // llamamos a nuesta tabla //
        String[] columnas = {"Codigo de revision", "Codigo de Administrador", "Codigo Alumno", "Fecha Revision", "Matricula"}; // creamos nuestras columnas //
        model = new DefaultTableModel(null, columnas); // asigamos a nuestro modelo //

        String sql = "select codigo_revision, codigo_administrador, codigo_alumno, TO_CHAR(fecha_revision,'DD/MM/YY'), matricula" + 
                     " from revalumno"+
                     " where codigo_alumno = "+ codigo + 
                     "order by codigo_revision"; // creamos nuestra secuencia SQL

        String[] filas = new String[5]; // creamos el Array de filas
        Statement st = null; // ejecutar el Query //
        ResultSet rs = null; // va obtener el resultaado //
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) { // recorrido
                for (int i = 0; i < 5; i++) { // guarda los datos en las filas
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas); // agregar filas //
            }
            tabla.setModel(model); // se guardan las filas
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
    
    
    
}
