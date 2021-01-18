/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.entity;


/**
 *
 * @author Jose
 */
public class Alumno 
{
    
    private int idAlumno;
    private String nombres;
    private String fechaNac;
    private String grado;
    private String seccion;
    private String direccion;
    private String email;
    private String alcontraseña;

    public Alumno() {
    }

    public Alumno(int idEmpleado, String nombres, String fechaNac, String grado, String seccion, String direccion, String email, String alcontraseña) {
        this.idAlumno = idEmpleado;
        this.nombres = nombres;
        this.fechaNac = fechaNac;
        this.grado = grado;
        this.seccion = seccion;
        this.direccion = direccion;
        this.email = email;
        this.alcontraseña = alcontraseña;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idEmpleado) {
        this.idAlumno = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlcontraseña() {
        return alcontraseña;
    }

    public void setAlcontraseña(String alcontraseña) {
        this.alcontraseña = alcontraseña;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombres=" + nombres + ", fechaNac=" + fechaNac + ", grado=" + grado + ", seccion=" + seccion + ", direccion=" + direccion + ", email=" + email + ", alcontrase\u00f1a=" + alcontraseña + '}';
    }
    
    
      
 

    
}

