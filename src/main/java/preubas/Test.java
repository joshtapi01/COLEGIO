/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preubas;

import clases.BO.AlumnoBO;
import clases.BO.DocentesBO;
import clases.entity.Alumno;
import clases.entity.Docentes;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jose
 */
public class Test {
    AlumnoBO abo = new AlumnoBO();
    
    DocentesBO doBO = new DocentesBO();
    Docentes doce = new Docentes();
    Alumno al = new Alumno();
    String mensaje = "";
    
    public void insertarAL(){
        al.setNombres("Maria");
        al.setFechaNac("01/12/20");
        al.setGrado("5");
        al.setSeccion("C");
        al.setDireccion("Av.SigloXX 789");
        al.setEmail("Maria@hotmail.com");
        al.setAlcontraseña("Holi123");
        mensaje = abo.agregarAlumno(al);
        System.out.println(mensaje);
    }
    
    public void modificarAL(){
        al.setIdAlumno(33334);
        al.setNombres("Yolanda");
        al.setFechaNac("12/12/12");
        al.setGrado("5");
        al.setSeccion("C");
        al.setDireccion("Tarapaca");
        al.setEmail("Calima.com");
        al.setAlcontraseña("Holi123");
        mensaje = abo.modificarAlumno(al);
        System.out.println(mensaje);
    }
    
    public void eliminarAL(){
        mensaje = abo.eliminarAlumno(1);
        System.out.println(mensaje);
    }
    
    public void insertarDo(){
        doce.setIdDocente(33338);
        doce.setNombre("Nuevo docente");
        doce.setDireccion("Av. de prueba 201");
        doce.setTelefono(456987);
        doce.setEmail("Preuba123@hotmail.com");
        doce.setCurso("Logica avanzada");
        doce.setSalario(3200);
        doce.setDoContraseña("Prueba 123");
        mensaje = doBO.agregarDocente(doce);
        System.out.println(mensaje);
    }
    
    public void modificarDo(){
        doce.setIdDocente(33338);
        doce.setNombre("Jorge");
        doce.setDireccion("Av.Sochimil 201");
        doce.setTelefono(123456);
        doce.setEmail("Jorge@hotmail.com");
        doce.setCurso("Filosofia");
        doce.setSalario(1500);
        doce.setDoContraseña("Prueba 123");
        mensaje = doBO.modificarDocente(doce);
        System.out.println(mensaje);
    }
    
    public static void main(String[] args) {
        Test test = new Test();
        //test.insertarAL();
        //test.modificarAL();
        //test.eliminarAL();
        //test.insertarDo();
        test.modificarDo();
    }
}
