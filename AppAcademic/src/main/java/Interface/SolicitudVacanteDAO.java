package Interface;

import java.util.List;

public interface SolicitudVacanteDAO {
    List<String[]> getAllSolicitudes();
    List<String[]> getSolicitudesByPadreId(int padreId);
    boolean updateEstadoSolicitud(int id, String nuevoEstado);
    List<String[]> getDetailsSolicitud(int solicitudId);
    int insertarYBuscarAula(int solicitudId);
    boolean insertarPersonaAula(int personaId, int aulaId);
    boolean procesarAprobacionSolicitud(int solicitudId);
}
