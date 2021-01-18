/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Jose
 */
public class cBaseDatos {
    
    private static Connection conn = null;
    private static String login = "Colegio";
    private static String clave = "colegio123";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public Connection Conectar(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection xcon = DriverManager.getConnection(url,login,clave);
            return xcon;
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return null;
    }
    public void listarPrueba() throws SQLException{
        try{
            Connection con = DriverManager.getConnection(url, login, clave);
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("select * from administrador");
                
            while(res.next()){
                String xcod = res.getString(1);
                String xnom = res.getString(2);
                String xemail = res.getString(3);
                String xtelefono = res.getString(4);
                String xsalario = res.getString(5);
                String xdireccion = res.getString(6);
                String xcontraseña = res.getString(7);
                System.out.println(xcod + " - " + xnom + " - " + xemail + " - " + xtelefono + " - " + xsalario + " - " + xdireccion  + " - " + xcontraseña);
                }
                
                System.out.print("Conexion Satisfactoria");  
            }catch(SQLException e){
                System.out.println(e.getCause() + "\n" + e.getMessage());
            }
        }
    public boolean validarUsuario(String xcod, String xcla){
        try{
            Connection xcon = this.Conectar();
            String sql = "select count(*) from administrador where Nombre_apellido=? AND " + "adcontraseña=?";
            PreparedStatement ps=xcon.prepareStatement(sql);
            ps.setString(1, xcod);
            ps.setString(2, xcla);
            ResultSet rs = ps.executeQuery();
             rs.next();
            String cantidad = rs.getString(1);
            int xcant = Integer.parseInt(cantidad);
            if (xcant > 0){
                return true;}
            xcon.close();
            return false;
        }catch (Exception ex){
            System.out.println(ex.toString());
            
        }
        return false;

    } 
    
    protected String generarCodigo(String tabla, String campo) throws SQLException {
        String rpta = "";
        String sql = "select count(*) from " + tabla;
        Connection xcon = this.Conectar();
        Statement st = xcon.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int cant = Integer.parseInt(rs.getString(1).toString());
        if ( cant <= 0 )
            rpta = "1";
        else {
            sql = "select max(" + campo + ") from " + tabla;
            rs = st.executeQuery(sql);
            rs.next();
            cant = Integer.parseInt(rs.getString(1).toString()) + 1;
            rpta = "" + cant;
    }
    xcon.close();
    return rpta;
}

    
    }
    
    

