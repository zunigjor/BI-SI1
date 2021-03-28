package fit.cvut.si1.semestralka.tattooPro.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controller for root page - mostly visual things and log in feature
 */
@Controller
@RequestMapping(value = "/")
public class rootController {

    /**
     * Root of the webpage
     * @return redirect to /users, whitch is considered to be the main page
     */
    @GetMapping
    public String getMainPage(Model model){
        return "redirect:/users";
    }

    /**
     * Page with info about authors
     * @return corresponding jsp
     */
    @GetMapping("/info")
    public String getInfo(Model model){
        return "infoPage";
    }

    /**
     * Login form
     * @return corresponding jsp with optional paramers errorMsg (eg.: wrong passwd) and msg (succesful logout)
     */
    @GetMapping("/login")
    public String getUserLogin(Model model, String error, String logout){
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }

    /**
     * Error page
     * @return
     */
    @GetMapping("/bad")
    public String getErrorPage(Model model){
        return "bad";
    }


}
