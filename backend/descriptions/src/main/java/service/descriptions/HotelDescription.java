package service.descriptions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "descriptions")
public class HotelDescription implements Serializable  {

    @Id
    private String id;

    @Column(nullable = false, length = 30)
    private String hotelName;

    @Column(nullable = false, length = 45)
    private String shortDescription;

    public HotelDescription() {}

    // stored as URLs
    @Column(nullable = false, unique = true, length = 200)
    private String thumbnail;

    @ElementCollection
    private List<String> images = new ArrayList<String>();;

    @Column(nullable = false, length = 30)
    private String hotelLocation;

    @Column(nullable = false, unique = true, length = 100)
    private String longDescription;

    @ElementCollection
    private List<String> popularAttractions = new ArrayList<String>();

    @ElementCollection
    private List<String> facilities = new ArrayList<String>();

    @Column(nullable = false, unique = true, length = 50)
    public String hotelLink;

    @ElementCollection
    private List<String> publicTransport = new ArrayList<String>();

    public HotelDescription(String id, String hotelName, String shortDescription, String longDescription, String thumbnail, List<String> facilities,
    List<String> popularAttractions, String hotelLink, List<String> images, List<String> publicTransport) {
        this.id = id;
        this.hotelName = hotelName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.thumbnail = thumbnail;
        this.facilities = facilities;
        this.popularAttractions = popularAttractions;
        this.hotelLink = hotelLink;
        this.images = images;
        this.publicTransport = publicTransport;

    }

    public String getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public List<String> getPopularAttractions() {
        return popularAttractions;
    }

    public List<String> getPublicTransport() {
        return publicTransport;
    }

    public String getHotelLink() {
        return hotelLink;
    }

    public List<String> getImages() {
        return images;
    }

}