package Model;

public class Seccion {
    private int id;
    private String nombre;

    public Seccion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return nombre; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Seccion seccion = (Seccion) obj;
        return id == seccion.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
