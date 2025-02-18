<<<<<<< HEAD
package service.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HotelDescription implements Serializable  {

    private String id;

    private String hotelName;

    private String shortDescription;

    public HotelDescription() {}

    private String thumbnail;

    private List<String> images = new ArrayList<String>();;

    private String hotelLocation;

    private String longDescription;

    private List<String> popularAttractions = new ArrayList<String>();


    private List<String> facilities = new ArrayList<String>();

    public String hotelLink;

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

=======
package service.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HotelDescription implements Serializable  {

    private String id;

    private String hotelName;

    private String shortDescription;

    public HotelDescription() {}

    private String thumbnail;

    private List<String> images = new ArrayList<String>();;

    private String hotelLocation;

    private String longDescription;

    private List<String> popularAttractions = new ArrayList<String>();


    private List<String> facilities = new ArrayList<String>();

    public String hotelLink;

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

>>>>>>> 7ed26a575c82056c541dccc9a7d08fdf51f5819a
}