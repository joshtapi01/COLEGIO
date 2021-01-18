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
public class Docentes {
    private int idDocente;
    private String nombre;
    private String direccion;
    private int telefono;
    private String email;
    private String curso;
    private int Salario;
    private String doContraseña;
    
    public Docentes() {
    }

    public Docentes(int idDocente, String nombre, String direccion, int telefono, String email, String curso, int Salario, String doContraseña) {
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.curso = curso;
        this.Salario = Salario;
        this.doContraseña = doContraseña;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int Salario) {
        this.Salario = Salario;
    }

    public String getDoContraseña() {
        return doContraseña;
    }

    public void setDoContraseña(String doContraseña) {
        this.doContraseña = doContraseña;
    }

    @Override
    public String toString() {
        return "Docentes{" + "idDocente=" + idDocente + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", curso=" + curso + ", Salario=" + Salario + ", doContrase\u00f1a=" + doContraseña + '}';
    }
    
    
    
    
    
    
    
}
