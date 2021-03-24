package fit.cvut.si1.semestralka.tattooPro.logic.service.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.ICustomerDAO;
import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.ITattooArtistDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;
import fit.cvut.si1.semestralka.tattooPro.data.entities.User;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service that helps us with finding used usernames, email etc. All users inherits it
 */
@Service
public class UserService implements IUserService {
    /**
     * Password encoder.
     */
    @Autowired
    protected BCryptPasswordEncoder bCryptPasswordEncoder;
    /**
     * Tattoo artist data access object.
     */
    @Autowired
    protected ITattooArtistDAO tattooArtistDAO;
    /**
     *  Customer data access object.
     */
    @Autowired
    protected ICustomerDAO customerDAO;
    /**
     * Checks whether username is taken.
     * @param username Username
     * @return True when the username is taken, false otherwise.
     */
    @Override
    @Transactional
    public boolean isUserNameTaken(String username){
        return !tattooArtistDAO.findByUsername(username).isEmpty() || !customerDAO.findByUsername(username).isEmpty();
    }
    /**
     * Checks whether email is taken.
     * @param email Email
     * @return True when the email is taken, false otherwise.
     */
    @Override
    @Transactional
    public boolean isEmailTaken(String email){
        return !tattooArtistDAO.findByEmail(email).isEmpty() || !customerDAO.findByEmail(email).isEmpty();
    }
    /**
     * Adds a user to the database.
     * @param user User to be added
     * @param isArtist Insert true if the user is artist.
     * @return 0 on success, -1 on username taken, -2 on email taken
     */
    @Override
    @Transactional
    public int add(User user, boolean isArtist) {
        if(isUserNameTaken(user.getUsername())) return -1;
        if(isEmailTaken(user.getEmail())) return -2;
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setProfilePicture(User.getDefaultProfilePic());
        if(isArtist) tattooArtistDAO.persist((TattooArtist)user);
        else customerDAO.persist((Customer)user);
        return 0;
    }
}
