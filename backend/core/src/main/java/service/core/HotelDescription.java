package service.core;

public class HotelDescription {

    private String id;
    private String shortDescription;

    public HotelDescription() {}

    private String thumbnail;
    private String[] images;

    private String location;

    private String longDescription;

    private String[] popularAttractions;

    private String[] facilities;

    public String hotelLink;

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