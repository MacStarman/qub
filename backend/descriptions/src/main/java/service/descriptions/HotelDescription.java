package service.descriptions;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "descriptions")
public class HotelDescription implements Serializable  {

    @Id
    private String id;

    @Column(nullable = false, length = 45)
    private String shortDescription;

    public HotelDescription() {}

    // stored as URLs
    @Column(nullable = false, unique = true, length = 30)
    private String thumbnail;

    @ElementCollection(targetClass=String.class)
    @OrderColumn(name = "pos")
    private String[] images;

    @Column(nullable = false, unique = true, length = 30)
    private String location;

    @Column(nullable = false, unique = true, length = 30)
    private String longDescription;

    @ElementCollection(targetClass=String.class)
    @OrderColumn(name = "pos")
    private String[] popularAttractions;

    @ElementCollection(targetClass=String.class)
    @OrderColumn(name = "pos")
    private String[] facilities;

    @Column(nullable = false, unique = true, length = 30)
    public String hotelLink;

    @ElementCollection(targetClass=String.class)
    @OrderColumn(name = "pos")
    private String[] publicTransport;

    public HotelDescription(String id, String shortDescription, String longDescription, String thumbnail, String[] facilities,
        String[] popularAttractions, String hotelLink, String[] images) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.thumbnail = thumbnail;
        this.facilities = facilities;
        this.popularAttractions = popularAttractions;
        this.hotelLink = hotelLink;
        this.images = images;

    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
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

    public String[] getFacilities() {
        return facilities;
    }

    public String[] getPopularAttractions() {
        return popularAttractions;
    }

    public String[] getPublicTransport() {
        return publicTransport;
    }

    public String getHotelLink() {
        return hotelLink;
    }

    public String[] getImages() {
        return images;
    }

}