/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.DAO;

import clases.entity.Docentes;
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
public class DocentesDAO {

    private String mensaje;

    public String agregarDocente(Connection conn, Docentes doce) {
        PreparedStatement pst = null;
        String sql = "insert into docente (codigo_docente, nombre_apellido, direccion, telefono, email, curso, salario, doContraseña)" + "values(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, doce.getIdDocente());
            pst.setString(2, doce.getNombre());
            pst.setString(3, doce.getDireccion());
            pst.setInt(4, doce.getTelefono());
            pst.setString(5, doce.getEmail());
            pst.setString(6, doce.getCurso());
            pst.setInt(7, doce.getSalario());
            pst.setString(8, doce.getDoContraseña());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        } catch (Exception e) {
            mensaje = "NO SE GUARDADO CORRECTAMENTE" + e.getMessage();
        }
        return mensaje;
    }

    public String modificarDocente(Connection conn, Docentes doce) {
        PreparedStatement pst = null;
        String sql = "UPDATE docente set nombre_apellido = ?, direccion = ?, telefono = ?, email = ?, curso = ?, salario = ?, doContraseña = ?" + "where codigo_docente = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, doce.getNombre());
            pst.setString(2, doce.getDireccion());
            pst.setInt(3, doce.getTelefono());
            pst.setString(4, doce.getEmail());
            pst.setString(5, doce.getCurso());
            pst.setInt(6, doce.getSalario());
            pst.setString(7, doce.getDoContraseña());
            pst.setInt(8, doce.getIdDocente());
            mensaje = "MODIFICADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        } catch (Exception e) {
            mensaje = "NO SE MODIFICAR CORRECTAMENTE " + e.getMessage();
        }
        return mensaje;

    }

    public String eliminarDocente(Connection conn, int id) {
        PreparedStatement pst = null;
        String sql = "delete from docente where codigo_docente = ?";

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

    public void listarDocente(Connection conn, JTable tabla) {
        DefaultTableModel model; // llamamos a nuesta tabla //
        String[] columnas = {"Codigo", "Nombres y apellidos", "Direccion", "Telefono", "Email", "Curso", "Salario", "Contraseña"}; // creamos nuestras columnas //
        model = new DefaultTableModel(null, columnas); // asigamos a nuestro modelo //

        String sql = "select * from docente order by codigo_docente"; // creamos nuestra secuencia SQL

        String[] filas = new String[8]; // creamos el Array de filas
        Statement st = null; // ejecutar el Query //
        ResultSet rs = null; // va obtener el resultaado //
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) { // recorrido
                for (int i = 0; i < 8; i++) { // guarda los datos en las filas
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
        String sql = "select max(codigo_docente) + 1 from docente";
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
