package service;

import service.core.BookingForm;

import java.util.concurrent.TimeUnit;

/**
 * Implementation of the AuldFellas insurance quotation service.
 *
 * @author Rem
 *
 */
public class PriceService{
    // All references are to be prefixed with an AF (e.g. AF001000)
    public static final String PREFIX = "AF";
    public static final String COMPANY = "Auld Fellas Ltd.";

    /**
     * Quote generation:
     * 30% discount for being male
     * 20% increase for being female
     * 10% discount for males over 50
     * additional 10% discount for males over 60
     */

    public double computePrice(BookingForm bookingForm, double hotelPrice) {
        long bookedMillies = Math.abs(bookingForm.endDate.getTime() - bookingForm.startDate.getTime());
        long bookedDays = TimeUnit.DAYS.convert(bookedMillies, TimeUnit.MILLISECONDS);

        return hotelPrice * bookingForm.persons * bookedDays;
    }
}
