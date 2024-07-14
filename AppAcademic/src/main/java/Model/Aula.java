package Model;

public class Aula {
    private int ID;
    private String nombre;
    private int anio;
    private Grado grado;
    private Seccion seccion;
    private String tutor;  

    public Aula(int ID, String nombre, int anio, Grado grado, Seccion seccion, String tutor) {
        this.ID = ID;
        this.nombre = nombre;
        this.anio = anio;
        this.grado = grado;
        this.seccion = seccion;
        this.tutor = tutor;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}
