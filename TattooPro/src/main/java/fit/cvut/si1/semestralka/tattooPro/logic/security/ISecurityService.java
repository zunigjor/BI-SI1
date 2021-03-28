package fit.cvut.si1.semestralka.tattooPro.logic.security;

public interface ISecurityService {

    /**
     * get username of user that is currently logged in
     *
     * @return the username or null when user is not logged in
     */
    public String getLoggedInUsername();


    /**
     * Auto login user after registration
     */
    public void autoLogin(String username, String password);
}
