package fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Image;

import java.util.List;

/**
 * Interface for image service
 */
public interface IImageService {

    /**
     * Adds an image to the database.
     * @param image Image to be added
     * @return True on success
     */
    public boolean add(Image image);

    /**
     * Finds all images with id given by param.
     * @param id Image ID
     * @return List of all images with equal ID
     */
    public List<Image> findById(int id);

    /**
     * Lists all images of a user given by his username.
     * @param username User username
     * @return List of all images where the owners username is equal to the username from the param.
     */
    public List<Image> findByOwner(String username);
}
