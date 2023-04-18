package main.java.service.descriptions;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelDescription {

    private String id;

    private String shortDescription;

    public HotelDescription() {}

    // stored as URLs
    private String thumbnail;
    private ArrayList < String > images;

    private String location;
    private ArrayList < String > longDescription;
    private ArrayList < String > popularAttractions;

    private ArrayList < String > facilities;
    public String hotelLink;

    // name of transport e.g. train followed by distance e.g. train station 200m from hotel.
    private HashMap < String, String > publicTransportMap = new HashMap < String, String > ();


    public HotelDescription(String id, String shortDescription, String longDescription, String thumbnail, ArrayList < String > facilities,
        ArrayList < String > popularAttractions, String hotelLink, ArrayList < String > images) {
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

    public ArrayList < String > getFacilities() {
        return facilities;
    }

    public ArrayList < String > getPopularAttractions() {
        return popularAttractions;
    }

    public HashMap < String, String > getPublicTransportMap() {
        return publicTransportMap;
    }

    public String getHotelLink() {
        return hotelLink;
    }

    public ArrayList < String > getImages() {
        return images;
    }
}