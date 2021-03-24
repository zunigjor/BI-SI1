package fit.cvut.si1.semestralka.tattooPro.data.DAO.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.ITattooArtistDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * TattooArtist repository
 * !!!
 * Database constraints are programmers responsibility.
 * (Adding multiple things with the same id makes the database go boom)
 * !!!
 */
@Repository
public class TattooArtistDAO implements ITattooArtistDAO {
    @PersistenceContext
    private EntityManager em;
    /**
     * Persists a tattoo artist.
     * @param tattooArtist Tattoo artist to be saved.
     */
    @Override
    public void persist(TattooArtist tattooArtist) {
        em.persist(tattooArtist);
    }
    /**
     * Updates a tattoo artist.
     * @param tattooArtist Tattoo artist to be updated.
     */
    @Override
    public void update(TattooArtist tattooArtist){
        em.merge(tattooArtist);
    }
    /**
     * Removes a tattoo artist.
     * @param tattooArtist tattoo artist to be removed.
     */
    @Override
    public void remove(TattooArtist tattooArtist){
        em.remove(tattooArtist);
    }
    /**
     * Finds all tattoo artists.
     * @return List of all tattoo artists.
     */
    @Override
    public List findAll() {
        return em.createQuery("SELECT t FROM TattooArtist t").getResultList();
    }
    /**
     * Finds a tattoo artist with selected ID.
     * @param id Tattoo artist ID.
     * @return List of all tattoo artists with such ID.
     */
    @Override
    public List findById(int id){
        return em.createQuery("SELECT t FROM TattooArtist t WHERE t.userID = :uid").setParameter("uid",id).getResultList();
    }
    /**
     * Finds a tattoo artist with selected username.
     * @param username Tattoo artist username.
     * @return List of all tattoo artists with such username.
     */
    @Override
    public List findByUsername(String username){
        return em.createQuery("SELECT t FROM TattooArtist t WHERE t.username = :uid").setParameter("uid",username).getResultList();
    }
    /**
     * Finds a tattoo artist with selected email.
     * @param email Tattoo artist email.
     * @return List of all tattoo artists with such email.
     */
    @Override
    public List findByEmail(String email){
        return em.createQuery("SELECT t FROM TattooArtist t WHERE t.email = :uid").setParameter("uid",email).getResultList();
    }
}