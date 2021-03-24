package fit.cvut.si1.semestralka.tattooPro.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * TattooStyle entity represents the artistic style of a tattoo.
 */
@Entity
public class TattooStyle {
    /**
     * TattooStyleID
     */
    @Id
    @GeneratedValue
    private int tattooStyleID;
    /**
     * Tattoo style name.
     */
    private String tattooStyle;
    /**
     * Artists which have this style listed on their profile.
     */
    @ManyToMany(mappedBy = "tattooStyles")
    private List<TattooArtist> tattooArtists;
    /**
     * Empty constructor.
     */
    public TattooStyle(){}
    /**
     * Constructor with params.
     * @param tattooStyleID ID
     * @param tattooStyle Tattoo style name
     * @param tattooArtists Artists with such style
     */
    public TattooStyle(int tattooStyleID, String tattooStyle, List<TattooArtist> tattooArtists){
        this.tattooStyleID = tattooStyleID;
        this.tattooStyle = tattooStyle;
        this.tattooArtists = tattooArtists;
    }

    public String getTattooStyle() {
        return tattooStyle;
    }
    public void setTattooStyle(String tattooStyle) {
        this.tattooStyle = tattooStyle;
    }

    public int getTattooStyleID() {
        return tattooStyleID;
    }
    public void setTattooStyleID(int tattooStyleID) {
        this.tattooStyleID = tattooStyleID;
    }
}
