package fit.cvut.si1.semestralka.tattooPro.web.DTO;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;

/**
 * DTO for customer
 */
public class CustomerDTO extends UserDTO{
    /**
     * Constructor with param.
     * @param customer Customer
     */
    public CustomerDTO(Customer customer) { super(customer.getUsername(),customer.getEmail()); }
    /**
     * Constructor with params.
     * @param username Username.
     * @param email EMail.
     */
    public CustomerDTO(String username, String email) { super(username, email); }
}
