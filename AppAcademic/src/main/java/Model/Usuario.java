package Model;

import java.time.LocalDate;
import org.mindrot.jbcrypt.BCrypt;

public abstract class Usuario extends Persona {
    private String username;
    private String password;
    private String rol;
    private boolean isActive;

    public Usuario(int id, String nombre, String apellidos, String dni, String sexo, LocalDate fechaNacimiento, String telefono, String direccion, String email, String username, String password, String rol, boolean isActive) {
        super(id, nombre, apellidos, dni, sexo, fechaNacimiento, telefono, direccion, email);
        this.username = username;
        this.password = hashPassword(password);
        this.rol = rol;
        this.isActive = isActive;
    }

    public Usuario() {
        super();
    }

    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Método para hashear la contraseña
    private String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }
}
