package Interface;

import Model.RegistrarApoderado;
import java.util.List;

public interface ApoderadoDAO {

    boolean insertApoderado(RegistrarApoderado apoderado);

    List<RegistrarApoderado> getAllApoderados();

    RegistrarApoderado getApoderadoByDni(String dni);

    boolean updateApoderado(RegistrarApoderado apoderado);

    boolean deleteApoderado(String dni);

    List<String[]> getApoderadosInfo();

    List<String[]> getApoderadosInfoByName(String nombre);
}
