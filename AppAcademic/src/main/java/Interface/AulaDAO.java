package Interface;

import Model.Aula;
import Model.Grado;
import Model.Seccion;
import java.util.List;

public interface AulaDAO {

    Aula getAulaById(int id);

    List<Aula> getAllAulas();

    boolean insertAula(Aula aula);

    boolean updateAula(Aula aula);

    boolean deleteAula(int id);

    List<Grado> getAllGrados();

    List<Seccion> getAllSecciones();

    List<String> getAllTutores();

    int obtenerTutorId(String tutorNombre);
}
