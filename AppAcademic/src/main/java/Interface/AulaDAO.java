package Interface;

import Model.Aula;
import java.util.List;

public interface AulaDAO {
    Aula getAulaById(int id);
    List<Aula> getAllAulas();
    boolean insertAula(Aula aula);
    boolean updateAula(Aula aula);
    boolean deleteAula(int id);
}
