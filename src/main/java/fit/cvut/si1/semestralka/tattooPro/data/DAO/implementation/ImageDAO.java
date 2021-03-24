package fit.cvut.si1.semestralka.tattooPro.data.DAO.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.IImageDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Image repository
 * !!!
 * Database constraints are programmers responsibility.
 * (Adding multiple things with the same id makes the database go boom)
 * !!!
 */
@Repository
public class ImageDAO implements IImageDAO {
    @PersistenceContext
    private EntityManager em;
    /**
     * Persists an image.
     * @param image Image to be saved.
     */
    @Override
    public void persist(Image image) {
        em.persist(image);
    }
    /**
     * Updates an image
     * @param image Image to be updated.
     */
    @Override
    public void update(Image image){
        em.merge(image);
    }
    /**
     * Removes an image.
     * @param image Image to be removed.
     */
    @Override
    public void remove(Image image){
        em.remove(image);
    }

    @Override
    public List listByOwner(String username){
        return em.createQuery("SELECT i FROM Image i WHERE i.imageOwner.username = :uid").setParameter("uid", username).getResultList();
    }
    /**
     * Lists image by ID.
     * @param Id Image ID.
     * @return Image with such ID in a List.
     */
    @Override
    public List findById(int Id){
        return em.createQuery("SELECT i FROM Image i WHERE i.imageID = :uid").setParameter("uid", Id).getResultList();
    }

}
