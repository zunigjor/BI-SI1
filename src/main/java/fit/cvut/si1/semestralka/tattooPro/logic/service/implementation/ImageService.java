package fit.cvut.si1.semestralka.tattooPro.logic.service.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.IImageDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Image;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Image service class
 */
@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageDAO imageDAO;
    /**
     * Adds an image to the database.
     * @param image Image to be added
     * @return True on success
     */
    @Override
    @Transactional
    public boolean add(Image image){
        imageDAO.persist(image);
        return true;
    }
    /**
     * Finds all images with id given by param.
     * @param Id Image ID
     * @return List of all images with equal ID
     */
    @Override
    @Transactional
    public List<Image> findById(int Id) {return  imageDAO.findById(Id);}
    /**
     * Lists all images of a user given by his username.
     * @param username User username
     * @return List of all images where the owners username is equal to the username from the param.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Image> findByOwner(String username){
        return imageDAO.listByOwner(username);
    }
}
