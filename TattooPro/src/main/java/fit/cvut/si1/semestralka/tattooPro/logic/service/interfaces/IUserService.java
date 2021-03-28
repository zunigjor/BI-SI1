package fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces;

import fit.cvut.si1.semestralka.tattooPro.data.entities.User;

/**
 * Interface for user service class
 */
public interface IUserService {

    /**
     * Checks whether username is taken.
     * @param username Username
     * @return True when the username is taken, false otherwise.
     */
    public boolean isUserNameTaken(String username);

    /**
     * Checks whether email is taken.
     * @param email Email
     * @return True when the email is taken, false otherwise.
     */
    public boolean isEmailTaken(String email);

    /**
     * Adds a user to the database.
     * @param user User to be added
     * @param isArtist Insert true if the user is artist.
     * @return 0 on success, -1 on username taken, -2 on email taken
     */
    public int add(User user, boolean isArtist);
}
