package fit.cvut.si1.semestralka.tattooPro.web.DTO;


/**
 * DTO classes as used to view profiles on web - only needed attributes.
 */
public abstract class UserDTO {
    protected String username;
    protected String email;
    /**
     * Empty constructor.
     */
    public UserDTO() {
    }
    /**
     * Constructor with params.
     * @param username Username
     * @param email EMail
     */
    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
