package Model;

public class Vacante {
    private int ID;
    private Grado grado;
    private Seccion seccion;
    private int cupoDisponible;

    public Vacante(int ID, Grado grado, Seccion seccion, int cupoDisponible) {
        this.ID = ID;
        this.grado = grado;
        this.seccion = seccion;
        this.cupoDisponible = cupoDisponible;
    }

    public Vacante() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public int getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(int cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }
}
