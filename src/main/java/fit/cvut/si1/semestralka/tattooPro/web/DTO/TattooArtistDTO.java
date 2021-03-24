package fit.cvut.si1.semestralka.tattooPro.web.DTO;

import fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist;

/**
 * DTO for TattooArtist
 */
public class TattooArtistDTO extends UserDTO{
    private boolean isVerified;
    private int yearsOfExperience;
    private String pricePerHour;
    /**
     * Constructor with param.
     * @param artist Tattoo artist.
     */
    public TattooArtistDTO(TattooArtist artist) {
        super(artist.getUsername(), artist.getEmail());
        this.isVerified = artist.getVerified();
        this.yearsOfExperience = artist.getYearsOfExperience();
        this.pricePerHour = artist.getPricePerHour();
    }
    /**
     * Constructor with params.
     * @param username Username
     * @param email Email
     * @param isVerified Is verified
     * @param yearsOfExperience Years of experience
     * @param pricePerHour Price per hour
     */
    public TattooArtistDTO(String username, String email, boolean isVerified, int yearsOfExperience, String pricePerHour) {
        super(username, email);
        this.isVerified = isVerified;
        this.yearsOfExperience = yearsOfExperience;
        this.pricePerHour = pricePerHour;
    }

    public boolean getVerified() { return isVerified; }
    public void setVerified(boolean verified) { isVerified = verified; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public String getPricePerHour() { return pricePerHour; }
    public void setPricePerHour(String pricePerHour) { this.pricePerHour = pricePerHour; }
}
