package fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooStyle;

import java.util.List;


/**
 * Interface defining data layer interfaces for tattoo style management.
 */
public interface ITattooStyleDAO{
    /**
     * Persists a tattoo style.
     * @param tattooStyle Tattoo style to be saved.
     */
    void persist(TattooStyle tattooStyle);
    /**
     * Updates a tattoo style.
     * @param tattooStyle Tattoo style to be updated.
     */
    void update(TattooStyle tattooStyle);
    /**
     * Removes a tattoo style.
     * @param tattooStyle Tattoo style to be removed.
     */
    void remove(TattooStyle tattooStyle);
    /**
     * Lists tattoo style by owner.
     * @return List of all tattoo styles.
     */
    List findAll();
    /**
     * Lists tattoo style by ID.
     * @param id Tattoo style ID.
     * @return Tattoo style with such ID in a List.
     */
    List findById(int id);
}