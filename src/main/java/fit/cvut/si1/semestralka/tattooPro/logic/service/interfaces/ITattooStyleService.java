package fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces;

import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooStyle;

import java.util.List;

/**
 * Interface for tattooStule service class
 */
public interface ITattooStyleService {

    /**
     * Adds tattoo style to the database.
     * @param tattooStyle Tattoo style to be added.
     * @return True if the style was successfully added.
     */
    public boolean add(TattooStyle tattooStyle);

    /**
     * Updates tattoo style. If no such style is found adds it into the database.
     * @param tattooStyle Tattoo style to be updated.
     */
    public void update(TattooStyle tattooStyle);

    /**
     * Removes a tattoo style from the database.
     * @param id Tattoo style ID.
     * @return True if a style with such ID has been found and removed. False otherwise.
     */
    public boolean remove(int id);

    /**
     * Adds a list of tattoo styles.
     * @param tattooStyleList List of tattoo styles.
     */
    public void addAll(List<TattooStyle> tattooStyleList);

    /**
     * Returns a list of all tattoo styles.
     * @return List of all tattoo styles.
     */
    public List<TattooStyle> listAll();

    /**
     * Finds a tattoo style by its ID.
     * @param id Tattoo style ID.
     * @return Tattoo style.
     */
    public List<TattooStyle> findById(int id);

}
