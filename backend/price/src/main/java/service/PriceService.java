package service;
import service.core.BookingForm;
import java.util.concurrent.TimeUnit;

public class PriceService{
    public double computePrice(BookingForm bookingForm, double hotelPrice) {
        long bookedMillies = Math.abs(bookingForm.endDate.getTime() - bookingForm.startDate.getTime());
        long bookedDays = TimeUnit.DAYS.convert(bookedMillies, TimeUnit.MILLISECONDS);

        return hotelPrice * bookingForm.persons * bookedDays;
    }
}
