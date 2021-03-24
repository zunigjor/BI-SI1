package fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces;

import fit.cvut.si1.semestralka.tattooPro.data.entities.User;

import java.util.List;

/**
 * Interface defining data layer interfaces for users. Every other interface for instances of user should inherit from this one.
 */
public interface IUserDAO<U extends User> {
    /**
     * Persists a user.
     * @param user User to be saved.
     */
    void persist(U user);
    /**
     * Updates a user.
     * @param user User to be updated.
     */
    void update(U user);
    /**
     * Removes a user.
     * @param user User to be removed.
     */
    void remove(U user);
    /**
     * Lists all users.
     * @return
     */
    List findAll();
    /**
     * Finds a user by his ID.
     * @param id User ID.
     * @return Users with such ID in a List.
     */
    List findById(int id);
    /**
     * Finds a user by his username.
     * @param username User username.
     * @return Users with such username in a List.
     */
    List findByUsername(String username);
    /**
     * Finds a user by his email.
     * @param email User email.
     * @return Users with such email in a List.
     */
    List findByEmail(String email);


}
