package fit.cvut.si1.semestralka.tattooPro.logic.service.implementation;

import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;
import fit.cvut.si1.semestralka.tattooPro.logic.service.interfaces.ITattooArtistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Tattoo artist service class.
 */
@Service
public class TattooArtistService extends UserService implements ITattooArtistService {
    /**
     * Adds artist to the database
     * @param tattooArtist the artist
     * @return 0 on success, -1 on username taken, -2 on email taken
     */
    @Override
    @Transactional
    public int add(TattooArtist tattooArtist){
        return add(tattooArtist, true);
    }
    /**
     * Changes user password
     * @param tattooArtist artist to be updated
     * @return true if updated, false if there is no such user
     */
    public boolean changePassword(TattooArtist tattooArtist){
        tattooArtist.setPassword(bCryptPasswordEncoder.encode(tattooArtist.getPassword()));
        return update(tattooArtist);
    }
    /**
     * Updates a tattoo artist.
     * @param tattooArtist Tattoo artist to be updated.
     * @return true if updated, false if there is no such user
     */
    @Override
    @Transactional
    public boolean update(TattooArtist tattooArtist){
        if( findById(tattooArtist.getUserID()).isEmpty()) return false;
        tattooArtistDAO.update(tattooArtist);
        return true;
    }
    /**
     * Removes a tattoo artist by its ID.
     * @param id Tattoo artist user ID.
     * @return True if the artist was successfully removed. False otherwise.
     */
    @Override
    @Transactional
    public boolean remove(int id){
        List<TattooArtist> toR = findById(id);
        if(toR.isEmpty()) return false;
        tattooArtistDAO.remove(toR.get(0));
        return true;
    }
    /**
     * Adds a list of tattoo artists to the database.
     * @param tattooArtistList List of tattoo artists.
     */
    @Override
    @Transactional
    public void addAll(List<TattooArtist> tattooArtistList){
        for(TattooArtist tattooArtist : tattooArtistList){
            tattooArtistDAO.persist(tattooArtist);
        }
    }
    /**
     * Lists all tattoo artists.
     * @return List of all tattoo artists.
     */
    @Override
    @Transactional(readOnly = true)
    public List<TattooArtist> listAll() {
        return tattooArtistDAO.findAll();
    }
    /**
     * Finds a tattoo artist by its user ID.
     * @param id Tattoo artist user ID.
     * @return Tattoo artist.
     */
    @Override
    @Transactional(readOnly = true)
    public List<TattooArtist> findById(int id){
        return tattooArtistDAO.findById(id);
    }
    /**
     * Finds a tattoo artist by its username.
     * @param username Tattoo artist username.
     * @return Tattoo artist.
     */
    @Override
    @Transactional(readOnly = true)
    public List<TattooArtist> findByUsername(String username) { return tattooArtistDAO.findByUsername(username); }
}
