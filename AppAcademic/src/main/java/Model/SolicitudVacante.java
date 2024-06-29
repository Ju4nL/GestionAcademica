package Model;

import java.util.Date;

public class SolicitudVacante {
    private int id;
    private int padreId;
    private int alumnoId;
    private Grado grado;
    private Seccion seccion;
    private Date fechaSolicitud;
    private String estado;

    public SolicitudVacante(int id, int padreId, int alumnoId, Grado grado, Seccion seccion, Date fechaSolicitud, String estado) {
        this.id = id;
        this.padreId = padreId;
        this.alumnoId = alumnoId;
        this.grado = grado;
        this.seccion = seccion;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPadreId() {
        return padreId;
    }

    public void setPadreId(int padreId) {
        this.padreId = padreId;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
