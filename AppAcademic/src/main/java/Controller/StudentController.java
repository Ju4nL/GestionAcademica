
package Controller;
import Base.App;

//Model
import Model.HorarioModel;

//View
import View.StudentHomeFrame;

//Utils
import java.util.List;

public class StudentController {
    private StudentHomeFrame studentFrame;
    private HorarioModel horarioModel;
    private int usuarioID;

    public StudentController(StudentHomeFrame studentFrame, HorarioModel horarioModel, int usuarioID) {
        this.studentFrame = studentFrame;
        this.usuarioID = usuarioID;
        this.horarioModel = horarioModel;
         initController();
         verHorario();
    }
    
    public void initController() {
        studentFrame.getBtnHorario().addActionListener(e -> verHorario());
        studentFrame.getBtnCerrarSesion().addActionListener(e -> cerrarSesion());
    }
    
    public void verHorario() {
        List<String[]> data = horarioModel.getHorarios();
        studentFrame.getTblHorario().setModel(new View.ReporteHorario());  // Reiniciar modelo
        for (String[] row : data) {
            ((View.ReporteHorario) studentFrame.getTblHorario().getModel()).addHorario(
                row[0], row[1], row[2], row[3], row[4], row[5]
            );
        }
    }
    
    public void cerrarSesion() {
        studentFrame.dispose();
        
    }
}
