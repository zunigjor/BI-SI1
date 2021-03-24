package fit.cvut.si1.semestralka.tattooPro.web.controllers;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Customer;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Image;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ICustomerService;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.IImageService;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ITattooArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Controller for profile images
 */
@Controller
@RequestMapping("/images")
public class imageController {

    @Autowired
    IImageService imageService;

    @Autowired
    ITattooArtistService tattooArtistService;

    @Autowired
    ICustomerService customerService;

    /**
     * Get profile pic of selected user
     * @param response response with profile picture
     * @param username username of the user
     * @throws IOException when there is a problem with outputstream
     */
    @GetMapping("/{username}")
    public void getProfilePic(HttpServletResponse response, @PathVariable String username) throws IOException{


        List<TattooArtist> artist = tattooArtistService.findByUsername(username);
        List<Customer> customer = customerService.findByUsername(username);

        response.setContentType("image/jpg");

        if(artist.size() == 1 && customer.size() == 0){
            response.getOutputStream().write(artist.get(0).getProfilePicture());

        }
        else if(artist.size() == 0 && customer.size() == 1){
            response.getOutputStream().write(customer.get(0).getProfilePicture());
        }

    }

    /**
     * Get image on users profile
     * @param response response with the image
     * @param username username of the user
     * @param imgId ID of the image
     * @throws IOException when there is a problem with outputstream
     */
    @GetMapping("/{username}/{imgId}")
    public void getImage(HttpServletResponse response, @PathVariable String username, @PathVariable int imgId) throws IOException {

        List<Image> image = imageService.findById(imgId);
        if(image.size() == 1) response.getOutputStream().write(image.get(0).getImageData());
        response.setContentType("image/jpg");
    }

}
