package Model;
import java.time.LocalDate;

public class Docente extends Usuario {
    private String tutorAulaNombre;

    public Docente(int id, String nombre, String apellidos, String dni, String sexo, LocalDate fechaNacimiento, String telefono, String direccion, String email, String username, String password, String rol, boolean isActive, String tutorAulaNombre) {
        super(id, nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email, username, password, rol, isActive);
        this.tutorAulaNombre = tutorAulaNombre;
    }

    public Docente() {
        super();
    }

    // Getters y setters
    public String getTutorAulaNombre() {
        return tutorAulaNombre;
    }

    public void setTutorAulaNombre(String tutorAulaNombre) {
        this.tutorAulaNombre = tutorAulaNombre;
    }
}
