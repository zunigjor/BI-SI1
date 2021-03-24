package fit.cvut.si1.semestralka.tattooPro.logic.security;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.implementation.CustomerDAO;
import fit.cvut.si1.semestralka.tattooPro.data.DAO.implementation.TattooArtistDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

/**
 * springboot security class for currently logged user
 */
@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private TattooArtistDAO tattooArtistDAO;
    @Autowired
    private CustomerDAO customerDAO;

    /**
     * sets permisions for currently logged user
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<Customer> customer = customerDAO.findByUsername(username);
        List<TattooArtist> artist = tattooArtistDAO.findByUsername(username);

        if(customer.size() == 0 && artist.size() == 1){
            return new org.springframework.security.core.userdetails.User(artist.get(0).getUsername(),artist.get(0).getPassword(),new HashSet<>());
        }

        if(customer.size() == 1 && artist.size() == 0){
            return new org.springframework.security.core.userdetails.User(customer.get(0).getUsername(),customer.get(0).getPassword(),new HashSet<>());
        }

        throw new UsernameNotFoundException(username);
    }
}
