package fit.cvut.si1.semestralka.tattooPro.data.DAO.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.ITattooStyleDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooStyle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * TattooStyle repository
 * !!!
 * Database constraints are programmers responsibility.
 * (Adding multiple things with the same id makes the database go boom)
 * !!!
 */
@Repository
public class TattooStyleDAO  implements ITattooStyleDAO {
    @PersistenceContext
    private EntityManager em;
    /**
     * Persists a tattoo style.
     * @param tattooStyle Tattoo style to be saved.
     */
    @Override
    public void persist(TattooStyle tattooStyle) {
        em.persist(tattooStyle);
    }
    /**
     * Updates a tattoo style.
     * @param tattooStyle Tattoo style to be updated.
     */
    @Override
    public void update(TattooStyle tattooStyle){
        em.merge(tattooStyle);
    }
    /**
     * Removes a tattoo style.
     * @param tattooStyle Tattoo style to be removed.
     */
    @Override
    public void remove(TattooStyle tattooStyle){
        em.remove(tattooStyle);
    }
    /**
     * Lists tattoo style by owner.
     * @return List of all tattoo styles.
     */
    @Override
    public List findAll() {
        return em.createQuery("SELECT s FROM TattooStyle s").getResultList();
    }
    /**
     * Lists tattoo style by ID.
     * @param id Tattoo style ID.
     * @return Tattoo style with such ID in a List.
     */
    @Override
    public List findById(int id){
        return em.createQuery("SELECT s FROM TattooStyle s WHERE s.tattooStyleID = :uid").setParameter("uid",id).getResultList();
    }
}
