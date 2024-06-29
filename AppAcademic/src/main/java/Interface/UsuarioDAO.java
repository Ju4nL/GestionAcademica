package Interface;

import Model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    Usuario getUsuarioById(int id);
    List<Usuario> getAllUsuarios();
    boolean insertUsuario(Usuario usuario);
    boolean updateUsuario(Usuario usuario);
    boolean deleteUsuario(int id);
}
