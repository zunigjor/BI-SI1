package fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces;

import fit.cvut.si1.semestralka.tattooPro.data.entities.User;

import java.util.List;

/**
 * Service for User entites, that inherit from user
 * @param <U> type of subclass (Eg customer)
 */
public interface IInheritedUsersService <U extends User> extends IUserService {

    /**
     * Adds user to the database
     * @param user the user
     * @return 0 on success, -1 on username taken, -2 on email taken
     */
    public int add(U user);

    /**
     * Changes user password
     * @param user user to be updated
     * @return true if updated, false if there is no such user
     */
    public boolean changePassword(U user);

    /**
     * Updates an user.
     * @param user user to be updated.
     * @return true if updated, false if there is no such user
     */
    public boolean update(U user);

    /**
     * Removes an user by its ID.
     * @param id user ID.
     * @return True if the artist was successfully removed. False otherwise.
     */
    public boolean remove(int id);

    /**
     * Adds a list of users to the database.
     * @param userList List of users.
     */
    public void addAll(List<U> userList);

    /**
     * Lists all users.
     * @return List of all users.
     */
    public List<U> listAll();

    /**
     * Finds a user by its user ID.
     * @param id user ID.
     * @return the user or empty list.
     */
    public List<U> findById(int id);

    /**
     * Finds a user by its username.
     * @param username the username.
     * @return the user or empty list.
     */
    public List<U> findByUsername(String username);

}
