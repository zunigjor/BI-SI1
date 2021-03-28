package fit.cvut.si1.semestralka.tattooPro.data.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;


/**
 * Tattoo artist entity represents a tattoo artist.
 * Every tattoo artist is a user.
 * Every tattoo artist is NOT a customer.
 */
@Entity
public class TattooArtist extends User {
    /**
     * Years of experience the tattoo artist has.
     */
    private int yearsOfExperience;
    /**
     * Verification status. True = verified. False = not verified.
     */
    private boolean verified = false;
    /**
     * Artist's price per hour. Can be in any currency. Any range. That's why it's a string.
     */
    private String pricePerHour;
    /**
     * Styles in which the tattoo artist prefers to work.
     */
    @ManyToMany
    @JoinTable(
            name="tattooStyles",
            joinColumns = { @JoinColumn(name = "tattooStyleID") },
            inverseJoinColumns = { @JoinColumn(name = "name") }
    )
    private List<TattooStyle> tattooStyles;
    /**
     * Empty constructor.
     */
    public TattooArtist(){}

    /**
     * Constructor with parameters.
     * @param username Username
     * @param password Password
     * @param numberOfReports Number of reports
     * @param userID ID
     * @param yearsOfExperience Years of experience
     * @param verified Verified
     * @param pricePerHour Price per hour
     * @param tattooStyles Tattoo styles
     */
    public TattooArtist(String username, String password,
                        int numberOfReports,  int userID,
                        int yearsOfExperience, boolean verified,
                        String pricePerHour, List<TattooStyle> tattooStyles){
        this.username = username;
        this.password = password;
        this.numberOfReports = numberOfReports;
        this.userID = userID;
        this.yearsOfExperience = yearsOfExperience;
        this.verified = verified;
        this.pricePerHour = pricePerHour;
        this.tattooStyles = tattooStyles;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public boolean getVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getPricePerHour() {
        return pricePerHour;
    }
    public void setPricePerHour(String pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public List<TattooStyle> getTattooStyles() {
        return tattooStyles;
    }
    public void setTattooStyles(List<TattooStyle> tattooStyles) {
        this.tattooStyles = tattooStyles;
    }
}
