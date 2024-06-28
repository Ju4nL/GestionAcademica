
package Interface;
import Model.Vacante;
import java.util.List;

public interface VacanteDAO {
    Vacante getVacanteById(int id);
    List<Vacante> getAllVacantes();
    /*
    List<Vacante> getVacantesByName(String name);
    boolean insertVacante(Vacante curso);
    boolean updateVacante(Vacante curso);
    boolean deleteVacante(int id);*/
}
