package fit.cvut.si1.semestralka.tattooPro.data.entities;

import javax.persistence.Entity;

/**
 * Customer entity represents a customer.
 * Every customer is a user.
 * Every customer is NOT a tattoo artist.
 */
@Entity
public class Customer extends User {
    /**
     * Empty constructor.
     */
    public Customer(){}
    /**
     * Constructr with parameters.
     * @param username Username
     * @param password Password
     * @param numberOfReports Number of reports
     * @param userID ID
     */
    public Customer(String username, String password, int numberOfReports, int userID){
        this.username = username;
        this.password = password;
        this.numberOfReports = numberOfReports;
        this.userID = userID;
    }
}
