package fit.cvut.si1.semestralka.tattooPro.web.controllers;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Message;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;
import fit.cvut.si1.semestralka.tattooPro.data.entities.User;
import fit.cvut.si1.semestralka.tattooPro.logic.security.ISecurityService;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ICustomerService;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.IMessageService;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ITattooArtistService;
import fit.cvut.si1.semestralka.tattooPro.web.DTO.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for currently logged user
 */
@Controller
@RequestMapping("/myprofile")
public class profileController {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private ITattooArtistService tattooArtistService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IMessageService messageService;

    /**
     * Get mapping for profile page
     * @return coresponding jsp with currently logged user
     */
    @GetMapping
    public String getCurrentProfile(Model model){

        String username = securityService.getLoggedInUsername();

        List<TattooArtist> artist = tattooArtistService.findByUsername(username);
        List<Customer> customer = customerService.findByUsername(username);

        if(artist.size() != 0 && customer.size() != 0) return "redirect:bad";

        if(artist.size() == 1){
            model.addAttribute("user", artist.get(0));
            return "profileArtist";
        }
        else if(customer.size() == 1){
            model.addAttribute("user", customer.get(0));
            return "profileCustomer";
        }

        return "redirect:myprofile/bad";
    }

    /**
     * Get mapping for sent messages
     * @return corresponding jsp with sent messages
     */
    @GetMapping("/messages/sent")
    public String getSentMessages(Model model){
        String username = securityService.getLoggedInUsername();

        List<MessageDTO> messages = new ArrayList<>();

        for(Message msg : messageService.findBySender(username)){
            messages.add(new MessageDTO(msg));
        }
        model.addAttribute("sent", messages);

        return "messagesSent";

    }

    /**
     * Get mapping for recieved messages
     * @return corresponding jsp with recieved messages
     */
    @GetMapping("/messages/received")
    public String getRecievedMessages(Model model){
        String username = securityService.getLoggedInUsername();

        List<MessageDTO> messages = new ArrayList<>();

        for(Message msg : messageService.findByReceiver(username)){
            messages.add(new MessageDTO(msg));
        }
        model.addAttribute("received", messages);

        return "messagesReceived";
    }

    /**
     * Send a message
     * @param toUsername username of adresee
     * @param msgText text of the message
     * @return redrect to recieved messages or redirect to error page
     */
    @PostMapping("/messages/new")
    public String postMessage(Model model, @RequestParam("username") String toUsername, @RequestParam("messageText") String msgText){

        User from = getUserByUsername(securityService.getLoggedInUsername());
        User to = getUserByUsername(toUsername);

        if(from == null){
            model.addAttribute("errorMsg","not logged in");
            return "redirect:/bad";
        }
        if(to == null){
            model.addAttribute("errorMsg","addressee not found");
            return "redirect:/bad";
        }

        //create and add msg
        Message msg = new Message(from,to, msgText);
        messageService.add(msg);

        //update reciever
        to.addReceivedMessage(msg);
        if(to instanceof Customer){
            customerService.update((Customer)to);
        }
        else if(to instanceof TattooArtist){
            tattooArtistService.update((TattooArtist)to);
        }
        else {
            model.addAttribute("errorMsg", "user is not customer neither artist");
            return "redirect:/bad";
        }

        //update sender
        from.addSentMessage(msg);
        if(from instanceof TattooArtist){
            tattooArtistService.update((TattooArtist)from);
        }
        else if(from instanceof Customer){
            customerService.update((Customer)from);
        }
        else {
            model.addAttribute("errorMsg", "user is not customer neighter artist");
            return "redirect:/bad";
        }

        model.addAttribute("msg", "msg sent succesfully");
        return "redirect:/myprofile/messages/received";
    }

    /**
     * Update user details for tatoo artist
     * @param newEmail new mail
     * @param newExp new years of experience
     * @param newPrice new price
     * @return redirect to myprofile or to error page
     */
    @PostMapping("/artist/edit/profile")
    public String postArtistProfile(Model model, @RequestParam("email") String newEmail, @RequestParam(value = "exp", defaultValue = "0") int newExp, @RequestParam(value = "price", defaultValue = "0") int newPrice){

        TattooArtist currentUser = (TattooArtist) getUserByUsername(securityService.getLoggedInUsername());
        if(currentUser == null){
            model.addAttribute("errorMsg", "Must be logged in.");
            return "redirect:/bad";
        }
        if (newExp >= 0 && newPrice >= 0 && !newEmail.isEmpty()) {
            currentUser.setEmail(newEmail);
            currentUser.setYearsOfExperience(newExp);
            currentUser.setPricePerHour(Integer.toString(newPrice));
        } else {
            model.addAttribute("errorMsg", "New price cannot be below 0, new years of experience cannot be below 0, new email cannot be empty.");
            return "redirect:/myprofile/bad";
        }

        tattooArtistService.update(currentUser);

        return "redirect:/myprofile";
    }

    /**
     * Change password for current user
     * @param newPassword new password
     * @return redirect to myprofile or error page
     */
    @PostMapping("/artist/edit/password")
    public String postArtistPassword(Model model, @RequestParam("pass") String newPassword){
        return postPassword(model, newPassword);
    }

    /**
     * Set profile picture for current user
     * @param picture the picture
     * @return redirect to myprofile or error page
     */
    @PostMapping("/artist/edit/picture")
    public String postArtistProfilePicture(Model model, @RequestParam("myImage") MultipartFile picture){
        return postProfilePicture(model, picture);
    }

    @PostMapping("/customer/edit/profile")
    public String postArtistProfile(Model model, @RequestParam("email") String newEmail){

        Customer currentUser = (Customer) getUserByUsername(securityService.getLoggedInUsername());
        if(currentUser == null){
            model.addAttribute("errorMsg", "Must be logged in.");
            return "redirect:/bad";
        }

        if (!newEmail.isEmpty()){
            currentUser.setEmail(newEmail);
        } else {
            model.addAttribute("errorMsg", "New email cannot be empty.");
            return "redirect:/myprofile/bad";
        }

        customerService.update(currentUser);

        return "redirect:/myprofile";
    }

    /**
     * Change password for current user
     * @param newPassword new password
     * @return redirect to myprofile or error page
     */
    @PostMapping("/customer/edit/password")
    public String postCustomerPassword(Model model, @RequestParam("pass") String newPassword){
        return postPassword(model, newPassword);
    }

    /**
     * Set profile picture for current user
     * @param picture the picture
     * @return redirect to myprofile or error page
     */
    @PostMapping("/customer/edit/picture")
    public String postCustomerProfilePicture(Model model, @RequestParam("myImage") MultipartFile picture){
        return postProfilePicture(model, picture);
    }

    /**
     * Get mapping for errors in myprofile
     * @return corresponding jsp
     */
    @GetMapping(value = "/bad")
    public String problem(Model model){
        return "bad";
    }

    /**
     * Checks artists as well as customers for given username
     * @param username the username to be used
     * @return null or found user
     */
    private User getUserByUsername(String username){

        List<TattooArtist> artist = tattooArtistService.findByUsername(username);
        List<Customer> customer = customerService.findByUsername(username);

        if(artist.size() != 0 && customer.size() != 0) return null;

        if(artist.size() == 1){
            return artist.get(0);
        }
        else if(customer.size() == 1){
            return customer.get(0);
        }

        return null;
    }


    /**
     * Set profile picture for current user
     * @param picture the picture
     * @return redirect to myprofile or error page
     */
    private String postProfilePicture(Model model, MultipartFile picture){

        User currentUser = getUserByUsername(securityService.getLoggedInUsername());

        if(currentUser == null){
            model.addAttribute("errorMsg", "Must be logged in.");
            return "redirect:/bad";
        }

        try {
            currentUser.setProfilePicture(picture.getBytes());
        }
        catch (IOException e){
            //MultipartFile throws IOException in case of access errors (if the temporary store fails)
            model.addAttribute("errorMsg","error with your file");
            return "redirect:/myprofile/bad";
        }

        if(currentUser instanceof TattooArtist) tattooArtistService.update((TattooArtist)currentUser);
        else if(currentUser instanceof Customer) customerService.update((Customer)currentUser);
        else {
            model.addAttribute("errorMsg", "you are not a customer nor artist");
            return "redirect:/bad";
        }
        return "redirect:/myprofile";
    }


    /**
     * Change password for current user
     * @param newPassword new password
     * @return redirect to myprofile or error page
     */
    private String postPassword(Model model, String newPassword){

        User currentUser = getUserByUsername(securityService.getLoggedInUsername());
        if(currentUser == null){
            model.addAttribute("errorMsg", "Must be logged in.");
            return "redirect:/bad";
        }

        if(!newPassword.isEmpty()) {
            currentUser.setPassword(newPassword);
        }
        else{
            model.addAttribute("errorMsg", "Password cannot be empty");
            return "redirect:/myprofile/bad";
        }

        if(currentUser instanceof TattooArtist) tattooArtistService.changePassword((TattooArtist)currentUser);
        else if(currentUser instanceof Customer) customerService.changePassword((Customer)currentUser);
        else {
            model.addAttribute("errorMsg", "you are not a customer nor artist");
            return "redirect:/bad";
        }

        return "redirect:/myprofile";

    }

}
