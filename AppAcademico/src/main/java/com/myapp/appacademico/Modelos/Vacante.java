package com.myapp.appacademico.Modelos;
public class Vacante {
    private int VacanteID;
    private String Grado;
    private String Seccion;
    private int CupoDisponible;

    public Vacante() {
    }

    public int getVacanteID() {
        return VacanteID;
    }

    public void setVacanteID(int VacanteID) {
        this.VacanteID = VacanteID;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public String getSeccion() {
        return Seccion;
    }

    public void setSeccion(String Seccion) {
        this.Seccion = Seccion;
    }

    public int getCupoDisponible() {
        return CupoDisponible;
    }

    public void setCupoDisponible(int CupoDisponible) {
        this.CupoDisponible = CupoDisponible;
    }
    
    
}
