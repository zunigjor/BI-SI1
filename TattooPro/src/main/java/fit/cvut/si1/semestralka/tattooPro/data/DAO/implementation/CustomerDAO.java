package fit.cvut.si1.semestralka.tattooPro.data.DAO.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.ICustomerDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Customer repository
 * !!!
 * Database constraints are programmers responsibility.
 * (Adding multiple things with the same id makes the database go boom)
 * !!!
 */
@Repository
public class CustomerDAO implements ICustomerDAO {
    @PersistenceContext
    private EntityManager em;
    /**
     * Persists a customer.
     * @param customer Customer to be saved.
     */
    @Override
    public void persist(Customer customer) {
        em.persist(customer);
    }
    /**
     * Updates a customer.
     * @param customer Customer to be updated.
     */
    @Override
    public void update(Customer customer){
        em.merge(customer);
    }
    /**
     * Removes a customer.
     * @param customer Customer to be removed.
     */
    @Override
    public void remove(Customer customer){
        em.remove(customer);
    }
    /**
     * Finds all customers.
     * @return List of all customers.
     */
    @Override
    public List findAll() {
        return em.createQuery("SELECT c FROM Customer c").getResultList();
    }
    /**
     * Finds a customer with selected ID.
     * @param id Customer ID.
     * @return List of all customers with such ID.
     */
    @Override
    public List findById(int id){
        return em.createQuery("SELECT c FROM Customer c WHERE c.userID = :uid").setParameter("uid",id).getResultList();
    }
    /**
     * Finds a customer with selected username.
     * @param username Customer username.
     * @return List of all customers with such username.
     */
    @Override
    public List findByUsername(String username){
        return em.createQuery("SELECT c FROM Customer c WHERE c.username = :uid").setParameter("uid",username).getResultList();
    }
    /**
     * Finds a customer with selected email.
     * @param email Customer email.
     * @return List of all customer with such email.
     */
    @Override
    public List findByEmail(String email){
        return em.createQuery("SELECT c FROM Customer c WHERE c.email = :uid").setParameter("uid",email).getResultList();
    }
}
