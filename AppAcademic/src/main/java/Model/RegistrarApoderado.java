
package Model;
    
import Security.PasswordUtils;
import java.time.LocalDate;

public class RegistrarApoderado {
    private String nombre;
    private String apellidos;
    private String dni;
    private String sexo;
    private LocalDate fechaNac;
    private String telefono;
    private String email;
    private String direccion;
    private String contrasena;

    public RegistrarApoderado(String nombre, String apellidos, String dni, String genero, LocalDate fechaNac, String telefono, String email, String direccion, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.sexo = genero;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.contrasena = PasswordUtils.hashPassword(contrasena);
    }

    public RegistrarApoderado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return sexo;
    }

    public void setGenero(String genero) {
        this.sexo = genero;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = PasswordUtils.hashPassword(contrasena);
    }
    
    
}
