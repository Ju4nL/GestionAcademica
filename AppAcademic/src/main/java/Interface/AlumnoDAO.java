package Interface;

import Model.RegistrarAlumno;
import java.util.List;

public interface AlumnoDAO {

    boolean insertAlumno(RegistrarAlumno alumno);

    List<RegistrarAlumno> getAllAlumnos();

    RegistrarAlumno getAlumnoByDni(String dni);

    boolean updateAlumno(RegistrarAlumno alumno);

    boolean deleteAlumno(String dni);
    
    List<String[]>getAlumnosInfo();
    
    List<String[]> getAlumnosInfoByName(String nombre);
}

