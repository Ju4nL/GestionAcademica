
package Model;
 
public class Vacante {
    private int ID;
    private String Grado;
    private String Seccion;
    private int cupoDisponible;

    public Vacante(int ID, String Grado, String Seccion, int cupoDisponible) {
        this.ID = ID;
        this.Grado = Grado;
        this.Seccion = Seccion;
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
        return cupoDisponible;
    }

    public void setCupoDisponible(int cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }
    
}
