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
public class PersonalAdmin {
    
    private int idPersonalA;
    private String nombre;
    private String email;
    private int telefono;
    private int salario;
    private String direccion;
    private String contraseña;
       
    public PersonalAdmin() {
    }

    public PersonalAdmin(int idPersonalA, String nombre, String email, int telefono, int salario, String direccion, String contraseña) {
        this.idPersonalA = idPersonalA;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.salario = salario;
        this.direccion = direccion;
        this.contraseña = contraseña;
    }

    public int getIdPersonalA() {
        return idPersonalA;
    }

    public void setIdPersonalA(int idPersonalA) {
        this.idPersonalA = idPersonalA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "PersonalAdmin{" + "idPersonalA=" + idPersonalA + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", salario=" + salario + ", direccion=" + direccion + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    



    
    
  

    
}
