package fit.cvut.si1.semestralka.tattooPro.logic.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Security related tasks such as getting logged username or autolog after registration
 */
@Service
public class SecurityService implements ISecurityService{

    @Autowired
    private UserDetailsServiceImp userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * get username of user that is currently logged in
     *
     * @return the username or null when user is not logged in
     */
    public String getLoggedInUsername() {
        if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
            return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        }
        return null;
    }

    /**
     * Auto login user after registration
     */
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        }
    }

}
