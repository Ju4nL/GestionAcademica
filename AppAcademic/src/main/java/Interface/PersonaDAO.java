package Interface;

import Model.Persona;
import java.util.List;

public interface PersonaDAO {
    Persona getPersonaById(int id);
    List<Persona> getAllPersonas();
    boolean insertPersona(Persona persona);
    boolean updatePersona(Persona persona);
    boolean deletePersona(int id);
}
