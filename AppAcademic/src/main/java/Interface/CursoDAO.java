
package Interface;
import Model.Curso;
import java.util.List;

public interface CursoDAO {
    Curso getCursoById(int id);
    List<Curso> getAllCursos();
    List<Curso> getCursosByName(String name);
    boolean insertCurso(Curso curso);
    boolean updateCurso(Curso curso);
    boolean deleteCurso(int id);
}
