package fit.cvut.si1.semestralka.tattooPro.web.controllers;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;
import fit.cvut.si1.semestralka.tattooPro.data.entities.User;
import fit.cvut.si1.semestralka.tattooPro.logic.security.SecurityService;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller for registrations
 */
@Controller
@RequestMapping(value = "/register")
public class registrationController {


    @Autowired
    IUserService userService;

    @Autowired
    SecurityService securityService;

    /**
     * Register form
     * @return corresponding jsp
     */
    @GetMapping
    public String getUserRegistration(Model model){
        return "register";
    }

    /**
     * New profile creation
     *
     * @param username username
     * @param password password
     * @param email email
     * @param isArtist true if it is an artist
     * @return redirect to /myprofile on succes, redirect to /register on failure with errorMsg
     */
    @PostMapping
    public String postUserRegistration(Model model, @RequestParam("uname") String username, @RequestParam("pass") String password, @RequestParam("email") String email, @RequestParam(value = "isart", defaultValue = "false") boolean isArtist){

        User user;

        if(isArtist){
            user = new TattooArtist();
        }
        else {
            user = new Customer();
        }

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        int succes = userService.add(user, isArtist);

        if(succes == 0){
            securityService.autoLogin(username, password);
            return "redirect:/myprofile";
        }

        model.addAttribute("errorMsg", getRegistrationError(succes));
        return "redirect:/register";

    }

    /**
     * Convert error code to message
     *
     * @param e the code
     * @return the message
     */
    private String getRegistrationError(int e){

        if(e == -1) return "Username taken";
        if(e == -2) return "Email taken";

        return "Proste chyba";
    }



}
