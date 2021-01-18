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
public class Calificacion {
    
    private int idNota;
    private int nota_final;
    private String curso;
    private int idDocente;
    private int idAlumno;
    
    
    
    public Calificacion() {
    }
    
    public Calificacion(int idNota, int nota_final, String curso, int idDocente, int idAlumno) {
        this.idNota = idNota;
        this.nota_final = nota_final;
        this.curso = curso;
        this.idDocente = idDocente;
        this.idAlumno = idAlumno;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "idNota=" + idNota + ", nota_final=" + nota_final + ", curso=" + curso + ", idDocente=" + idDocente + ", idAlumno=" + idAlumno + '}';
    }
    
    
    
}
