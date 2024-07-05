
package Base;

public interface AppInterface {
    void onLoginSuccess(int usuarioID, String role);
    void onLoginFailed(String username);
    void onLogout(int usuarioID);
}
