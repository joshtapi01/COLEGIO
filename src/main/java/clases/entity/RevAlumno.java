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
public class RevAlumno {
    private int idRevision;
    private int idAdministrador;
    private int idAlumno;
    private String fechaRev;
    private String matricula;
    
    public RevAlumno(){
    
    }
    
    public RevAlumno(int idRevision, int idAdministrador, int idAlumno, String fechaRev, String matricula) {
        this.idRevision = idRevision;
        this.idAdministrador = idAdministrador;
        this.idAlumno = idAlumno;
        this.fechaRev = fechaRev;
        this.matricula = matricula;
    }

    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getFechaRev() {
        return fechaRev;
    }

    public void setFechaRev(String fechaRev) {
        this.fechaRev = fechaRev;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String contrato) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "RevAlumno{" + "idRevision=" + idRevision + ", idAdministrador=" + idAdministrador + ", idAlumno=" + idAlumno + ", fechaRev=" + fechaRev + ", matricula=" + matricula + '}';
    }
       
}
