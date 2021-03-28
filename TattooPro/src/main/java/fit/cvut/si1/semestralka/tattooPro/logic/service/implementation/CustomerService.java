package fit.cvut.si1.semestralka.tattooPro.logic.service.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Customer service class.
 */
@Service
public class CustomerService extends UserService implements ICustomerService {
    /**
     * Adds customer to database.
     * @param customer Customer to be added
     * @return 0 on success, -1 on username taken, -2 on email taken
     */
    @Override
    @Transactional
    public int add(Customer customer){ return add(customer, false); }
    /**
     * Changes user password
     * @param customer customer to be updated
     * @return true if updated, false if user not found
     */
    @Override
    @Transactional
    public boolean changePassword(Customer customer){
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        return update(customer);
    }
    /**
     * Updates customer, does not change password
     * @param customer Customer to be updated.
     * @return true if updated, false if user not found
     */
    @Override
    @Transactional
    public boolean update(Customer customer){
        if( findById(customer.getUserID()).isEmpty()) return false;
        customerDAO.update(customer);
        return true;
    }
    /**
     * Remove customer.
     * @param id Customer user ID.
     * @return True if customer was successfully removed. False otherwise.
     */
    @Override
    @Transactional
    public boolean remove(int id){
        List<Customer> toR = findById(id);
        if(toR.isEmpty()) return false;
        customerDAO.remove(toR.get(0));
        return true;
    }
    /**
     * Adds a list of customers to the database.
     * @param customerList List of customers.
     */
    @Override
    @Transactional
    public void addAll(List<Customer> customerList){
        for(Customer customer : customerList){
            customerDAO.persist(customer);
        }
    }
    /**
     * Lists all customers.
     * @return List of all customers
     */
    @Override
    @Transactional(readOnly = true)
    public List<Customer> listAll() {
        return customerDAO.findAll();
    }
    /**
     * Finds a customer by his user ID.
     * @param id User ID
     * @return Customer
     */
    @Override
    @Transactional(readOnly = true)
    public List<Customer> findById(int id){
        return customerDAO.findById(id);
    }
    /**
     * Finds a customer by his username.
     * @param username Customer username.
     * @return Customer
     */
    @Override
    @Transactional(readOnly = true)
    public List<Customer> findByUsername(String username) { return  customerDAO.findByUsername(username); }
}
