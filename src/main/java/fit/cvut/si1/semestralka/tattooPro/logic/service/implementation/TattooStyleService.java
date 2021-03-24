package fit.cvut.si1.semestralka.tattooPro.logic.service.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.DAO.interfaces.ITattooStyleDAO;
import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooStyle;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ITattooStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Tattoo style service class.
 */
@Service
public class TattooStyleService implements ITattooStyleService {
    /**
     * Tattoo style data access object.
     */
    @Autowired
    private ITattooStyleDAO tattooStyleDAO;
    /**
     * Adds tattoo style to the database.
     * @param tattooStyle Tattoo style to be added.
     * @return True if the style was successfully added.
     */
    @Override
    @Transactional
    public boolean add(TattooStyle tattooStyle){
        if(!findById(tattooStyle.getTattooStyleID()).isEmpty()) return false;
        tattooStyleDAO.persist(tattooStyle);
        return true;
    }
    /**
     * Updates tattoo style. If no such style is found adds it into the database.
     * @param tattooStyle Tattoo style to be updated.
     */
    @Override
    @Transactional
    public void update(TattooStyle tattooStyle){
        if( findById(tattooStyle.getTattooStyleID()).isEmpty()) tattooStyleDAO.persist(tattooStyle);
        else tattooStyleDAO.update(tattooStyle);
    }
    /**
     * Removes a tattoo style from the database.
     * @param id Tattoo style ID.
     * @return True if a style with such ID has been found and removed. False otherwise.
     */
    @Override
    @Transactional
    public boolean remove(int id){
        List<TattooStyle> toR = findById(id);
        if(toR.isEmpty()) return false;
        tattooStyleDAO.remove(toR.get(0));
        return true;
    }
    /**
     * Adds a list of tattoo styles.
     * @param tattooStyleList List of tattoo styles.
     */
    @Override
    @Transactional
    public void addAll(List<TattooStyle> tattooStyleList){
        for(TattooStyle tattooStyle : tattooStyleList){
            tattooStyleDAO.persist(tattooStyle);
        }
    }
    /**
     * Returns a list of all tattoo styles.
     * @return List of all tattoo styles.
     */
    @Override
    @Transactional
    public List<TattooStyle> listAll() {
        return tattooStyleDAO.findAll();
    }
    /**
     * Finds a tattoo style by its ID.
     * @param id Tattoo style ID.
     * @return Tattoo style.
     */
    @Override
    @Transactional
    public List<TattooStyle> findById(int id){
        return tattooStyleDAO.findById(id);
    }
}
