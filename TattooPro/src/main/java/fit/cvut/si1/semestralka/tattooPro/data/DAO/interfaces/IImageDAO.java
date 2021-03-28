package fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces;

import fit.cvut.si1.semestralka.tattooPro.data.entities.Image;

import java.util.List;
/**
 * Interface defining data layer interfaces for image management.
 */
public interface IImageDAO {
    /**
     * Persists an image.
     * @param image Image to be saved.
     */
    void persist(Image image);
    /**
     * Updates an image.
     * @param image Image to be updated.
     */
    void update(Image image);
    /**
     * Removes an image.
     * @param image Image to be removed.
     */
    void remove(Image image);
    /**
     * Lists images by owner.
     * @param username Owner of images.
     * @return List of all images
     */
    List listByOwner(String username);
    /**
     * Lists image by ID.
     * @param Id Image ID.
     * @return Image with such ID in a List.
     */
    List findById(int Id);
}
