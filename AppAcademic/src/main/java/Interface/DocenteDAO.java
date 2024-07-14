package Interface;

import Model.Docente;
import java.util.List;

 

public interface DocenteDAO {
    boolean insertDocente(Docente docente);
    Docente getDocenteById(int id);
    List<Docente> getAllDocentes();
    boolean updateDocente(Docente docente);
    boolean setDocenteActive(int id, boolean isActive);
    List<Docente> getDocentesByName(String nombre);  
}
