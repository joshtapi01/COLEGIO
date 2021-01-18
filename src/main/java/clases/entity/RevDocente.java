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
public class RevDocente {
    
    private int idRevision;
    private int idAdministrador;
    private int idDocente;
    private String FechaRevicion;
    private String contrato;
    
    public RevDocente(){
    
    }

    public RevDocente(int idRevision, int idAdministrador, int idDocente, String FechaRevicion, String contrato) {
        this.idRevision = idRevision;
        this.idAdministrador = idAdministrador;
        this.idDocente = idDocente;
        this.FechaRevicion = FechaRevicion;
        this.contrato = contrato;
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

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getFechaRevicion() {
        return FechaRevicion;
    }

    public void setFechaRevicion(String FechaRevicion) {
        this.FechaRevicion = FechaRevicion;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "RevDocente{" + "idRevision=" + idRevision + ", idAdministrador=" + idAdministrador + ", idDocente=" + idDocente + ", FechaRevicion=" + FechaRevicion + ", contrato=" + contrato + '}';
    }
    
    
    
}
