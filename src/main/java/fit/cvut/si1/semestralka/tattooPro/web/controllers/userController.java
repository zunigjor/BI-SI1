package fit.cvut.si1.semestralka.tattooPro.web.controllers;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ICustomerService;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ITattooArtistService;
import fit.cvut.si1.semestralka.tattooPro.web.DTO.CustomerDTO;
import fit.cvut.si1.semestralka.tattooPro.web.DTO.TattooArtistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for urls /users/*
 */
@Controller
@RequestMapping(value = "/users")
public class userController {

    @Autowired
    ITattooArtistService tattooArtistService;
    @Autowired
    ICustomerService customerService;

    /**
     * root page of website
     * @return corresponding jsp
     */
    @GetMapping
    public String getRoot(Model model){
        return "usersRoot";
    }

    /**
     * Error page
     * @return corresponding jsp with errorMsg
     */
    @GetMapping("/bad")
    public String problem(Model model){
        model.addAttribute("errorMsg", "no such profile");
        return "bad";
    }

    /**
     * Ulr for browsing all artists
     * @return corresponding jsp with all artists
     */
    @GetMapping("/artists")
    public String getArtists(Model model){

        List<TattooArtistDTO> artists = new ArrayList<>();

        for(TattooArtist artist : tattooArtistService.listAll()){
            artists.add(new TattooArtistDTO(artist));
        }

        model.addAttribute("artists", artists);

        return "usersArtists";
    }


    /**
     * Specific artist profile
     * @param username username of the artists
     * @return corresponding jsp with selected artist or redirect to /users/bad if there is no such artist
     */
    @GetMapping("/artist/{username}")
    public String getArtist(Model model, @PathVariable String username){


        List<TattooArtist> artist = tattooArtistService.findByUsername(username);
        if(artist.size() != 1) return "redirect:/users/bad";


        model.addAttribute("artist", new TattooArtistDTO(artist.get(0)));
        return "usersArtistProfile";
    }

    /**
     * Ulr for browsing all customers
     * @return corresponding jsp with all customers
     */
    @GetMapping("/customers")
    public String getCustomers(Model model){

        List<CustomerDTO> customers = new ArrayList<>();

        for(Customer customer : customerService.listAll()){
            customers.add(new CustomerDTO(customer));
        }

        model.addAttribute("customers", customers);
        return "usersCustomers";
    }

    /**
     * Specific customer profile
     * @param username username of the customer
     * @return corresponding jsp with selected customer or redirect to /users/bad if there is no such customer
     */
    @GetMapping("/customer/{username}")
    public String getCustomer(Model model, @PathVariable String username){


        List<Customer> customer = customerService.findByUsername(username);
        if(customer.size() != 1) return "redirect:/users/bad";

        model.addAttribute("customer", new CustomerDTO(customer.get(0)));
        return "usersCustomerProfile";
    }



}
