package Interface;
import Model.Grado;
import Model.Seccion;
import Model.Vacante;
import java.util.List;

public interface VacanteDAO {
    Vacante getVacanteById(int id);
    List<Vacante> getAllVacantes(); 
    List<Grado> getAllGrados();
    List<Seccion> getAllSecciones();
    boolean insertVacante(Vacante vacante);
    boolean updateVacante(Vacante vacante); 
    boolean deleteVacante(int id);
}

