package Modelos;
import Controladores.Seccion;

public class SeccionController {
    private Seccion modelodelaseccion;

    public SeccionController(Seccion modelodelaseccion) {
        this.modelodelaseccion = modelodelaseccion;
    }
    
    public void setSeccionID(int SeccionID){
        modelodelaseccion.setSeccionID(SeccionID);
    }
    public int getSeccionID(){
        return modelodelaseccion.getSeccionID();
    }
    public void setSeccionNombre(String SeccionNombre){
        modelodelaseccion.setSeccionNombre(SeccionNombre);
    }
    public String getSeccionNombre(){
        return modelodelaseccion.getSeccionNombre();
    }
}
