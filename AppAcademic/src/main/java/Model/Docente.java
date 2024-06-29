package Model;

import java.time.LocalDate; 

public class Docente extends Persona {
    public Docente(int id, String nombre, String apellidos, String dni, String sexo, LocalDate fechaNacimiento, String telefono, String direccion, String email) {
        super(id, nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email);
    }

    public Docente() {
        super();
    }

}
