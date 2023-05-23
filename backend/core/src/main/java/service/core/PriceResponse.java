package service.core;

import java.util.Date;

public class PriceResponse {
    private String hotelId;

    private Date startDate;

    private Date endDate;

    private double price;

    public PriceResponse(String hotelId, Date startDate, Date endDate, double price) {
        this.hotelId = hotelId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public PriceResponse() {

    }
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
