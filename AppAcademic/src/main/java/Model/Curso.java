
package Model;
 
public class Curso {
    private int ID;
    private String Nombre;
    private String Descripcion;

    public Curso(int ID, String Nombre, String Descripcion) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public Curso() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
