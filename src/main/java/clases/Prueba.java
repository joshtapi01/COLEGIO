/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class Prueba {
    public static void main(String[] args) throws SQLException {
        System.out.println("Prueba de acceso a la tabla Usuarios");
        cBaseDatos base = new cBaseDatos();
        base.listarPrueba();
    }
}
