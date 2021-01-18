/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.co.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class Conexion {
    
    private static Connection conn = null;
    private static String login = "Colegio";
    private static String clave = "colegio123";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, login, clave);
            conn.setAutoCommit(false);
            if (conn != null) {
                System.out.println("Conexion Exitosa");
                
            }else
                System.out.println("Conexion Erronea");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion Erronea " + e.getMessage());
        }
        return conn;
    }
    
    public void desconexion(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectar");
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
        
    }
}
