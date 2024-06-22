package Modelos;

import Controladores.Grado;

public class GradoController {
    private Grado modelodelgrado;

    public GradoController(Grado modelodelgrado) {
        this.modelodelgrado = modelodelgrado;
    }
    public void setGradoID(int GradoID){
        modelodelgrado.setGradoID(GradoID);
    }
    public int getGradoID(){
        return modelodelgrado.getGradoID();
    }
    public void setGradoNombre(String GradoNombre){
        modelodelgrado.setGradoNombre(GradoNombre);
    }
    public String getGradoNombre(){
        return modelodelgrado.getGradoNombre();
    }
}
