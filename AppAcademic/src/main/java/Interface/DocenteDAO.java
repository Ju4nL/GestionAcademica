package Interface;

import Model.Docente;
import java.util.List;

public interface DocenteDAO {
    Docente getDocenteById(int id);
    List<Docente> getAllDocentes();
    boolean insertDocente(Docente docente);
    boolean updateDocente(Docente docente);
    boolean deleteDocente(int id);
}
