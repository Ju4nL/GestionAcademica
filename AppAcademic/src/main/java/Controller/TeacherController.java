package Controller;

//Model
import Model.HorarioTeacherModel;

//View
import View.TeacherHomeFrame;

//Utils
import java.util.List;

public class TeacherController {

    private TeacherHomeFrame teacherFrame;
    private HorarioTeacherModel horarioModel;
    private int usuarioID;

    public TeacherController(TeacherHomeFrame teacherFrame, HorarioTeacherModel horarioModel, int usuarioID) {
        this.teacherFrame = teacherFrame;
        this.horarioModel = horarioModel;
        this.usuarioID = usuarioID;
        initController();
        verHorario();

    }

    public void initController() {
        teacherFrame.getBtnCerrarSesion().addActionListener(e -> cerrarSesion());
    }

    public void verHorario() {
        List<String[]> data = horarioModel.getHorarios(usuarioID);
        teacherFrame.getTblHorarioTeacher().setModel(new View.ReporteHorario());
        for (String[] row : data) {
            ((View.ReporteHorario) teacherFrame.getTblHorarioTeacher().getModel()).addHorario(
                    row[0], row[1], row[2], row[3], row[4], row[5]
            );
        }
    }
    
    public void cerrarSesion() {
        teacherFrame.dispose();       
    }

}
