/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.DAO;

import clases.entity.PersonalAdmin;
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
public class PersonalDAO {
    
    private String mensaje;
    
    public String agregarPersonalA(Connection conn, PersonalAdmin per) {
        PreparedStatement pst = null;
        String sql = "insert into administrador (codigo_administrador, nombre_apellido, email, telefono, salario, direccion, adcontraseña)" + "values(?, ?, ?, ?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, per.getIdPersonalA());
            pst.setString(2, per.getNombre());
            pst.setString(3, per.getEmail());
            pst.setInt(4, per.getTelefono());
            pst.setInt(5, per.getSalario());  
            pst.setString(6, per.getDireccion());
            pst.setString(7, per.getContraseña());
            mensaje = "GUARDADO CORRECTAMENTE";
            pst.execute();
            pst.close();

        } catch (Exception e) {
            mensaje = "NO SE GUARDADO CORRECTAMENTE" + e.getMessage();
        }
        return mensaje;
    }
    
    public String modificarPersonalA(Connection conn, PersonalAdmin per){
         PreparedStatement pst = null;
        String sql = "UPDATE administrador set nombre_apellido = ?, email = ?, telefono = ?, salario = ?, direccion = ?, adcontraseña = ?" + "where codigo_administrador = ?";
        
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setString(1, per.getNombre());
            pst.setString(2, per.getEmail());
            pst.setInt(3, per.getTelefono());
            pst.setInt(4, per.getSalario());  
            pst.setString(5, per.getDireccion());
            pst.setString(6, per.getContraseña());
            pst.setInt(7, per.getIdPersonalA());
            mensaje = "MODIFICADO CORRECTAMENTE";
            pst.execute();
            pst.close();
           
        } catch (Exception e) 
        {
            mensaje = "NO SE MODIFICO CORRECTAMENTE " + e.getMessage();
        }
        return mensaje;
     
    }
    
    public String eliminarPersonalA(Connection conn, int id) {
        PreparedStatement pst = null;
        String sql = "delete from administrador where codigo_administrador = ?";
        
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
    
   public void listarPersonalA(Connection conn, JTable tabla) {
        DefaultTableModel model; // llamamos a nuesta tabla //
        String[] columnas = {"Codigo", "Nombres y apellidos", "Email", "Telefono", "Salario", "Direccion", "Contraseña"}; // creamos nuestras columnas //
        model = new DefaultTableModel(null, columnas); // asigamos a nuestro modelo //

        String sql = "select * from administrador order by codigo_administrador"; // creamos nuestra secuencia SQL

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
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla " + e.getMessage());
        }
    }
    
    public int getMaxID(Connection conn){
        int id = 0;
        PreparedStatement pst  = null;
        ResultSet rs = null;
        String sql = "select max(codigo_administrador) + 1 from administrador";
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
