package Controladores;
import Modelos.Curso;

public class CursoController {
    
    private Curso modelodelcurso;
    
    public CursoController(Curso model){
        this.modelodelcurso = model;
    }
    public void setCursoID(int ID){
        modelodelcurso.setID(ID);
    }
    public int getCursoID(){
        return modelodelcurso.getID();
    }
    public void setCursoNombre(String Nombre){
        modelodelcurso.setNombre(Nombre);
    }
    public String getCursoNombre(){
        return modelodelcurso.getNombre();
    }
    public void setCursoDescripcion(String Descripcion){
        modelodelcurso.setDescripcion(Descripcion);
    }
    public String getCursoDescripcion(){
        return modelodelcurso.getDescripcion();
    }
}
