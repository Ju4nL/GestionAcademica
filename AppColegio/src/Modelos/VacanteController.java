package AP3_4Clases;

import AP3_4Clases.Vacante;

public class VacanteController {
    private Vacante modelodelavacante;

    public VacanteController(Vacante modelodelavacante) {
        this.modelodelavacante = modelodelavacante;
    }
    
    public void setVacanteID(int VacanteID){
        modelodelavacante.setVacanteID(VacanteID);
    }
    public int getVacanteID(){
        return modelodelavacante.getVacanteID();
    }
    public void setGrado(String Grado){
        modelodelavacante.setGrado(Grado);
    }
    public String getGrado(){
        return modelodelavacante.getGrado();
    }
    public void setSeccion(String Seccion){
        modelodelavacante.setSeccion(Seccion);
    }
    public String getSeccion(){
        return modelodelavacante.getSeccion();
    }
    public void setCupoDisponible(int CupoDisponible){
        modelodelavacante.setCupoDisponible(CupoDisponible);
    }
    public int getCupoDisponible(){
        return modelodelavacante.getCupoDisponible();
    }
}
