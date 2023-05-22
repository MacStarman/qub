package service;

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

    public double computePrice(BookingDetails bookingForm) {
        String[] startSplit = bookingForm.startDate.split("/");
        int startDay = Integer.parseInt(startSplit[0]);
        int startMonth = Integer.parseInt(startSplit[1]);
        int startYear = Integer.parseInt(startSplit[2]);

        String[] endSplit = bookingForm.endDate.split("/");
        int endDay = Integer.parseInt(endSplit[0]);
        int endMonth = Integer.parseInt(endSplit[1]);
        int endYear = Integer.parseInt(endSplit[2]);

        int startMonthInDays = 0, endMonthInDays = 0;
        for(int i = 1; i < startMonth; i++){
            switch(i) {
                default:
                    startMonthInDays += 31;
                    break;
                case 2:
                    startMonthInDays += startYear%4 == 0 ? 29:28;
                    break;
                case 5, 7, 10, 12:
                    startMonthInDays += 30;
                    break;
            }
        }

        for(int i = 1; i < endMonth; i++){
            switch(i) {
                default:
                    endMonthInDays += 31;
                    break;
                case 2:
                    endMonthInDays += endYear%4 == 0 ? 29:28;
                    break;
                case 5, 7, 10, 12:
                    endMonthInDays += 30;
                    break;
            }
        }

        int startInDays = startYear*365 + startYear/4 + startMonthInDays + startDay;
        int endInDays = endYear*365 + endYear/4 + endMonthInDays + endDay;

        int bookedDays = endInDays - startInDays;

        return bookingForm.hotelPricePerDay * bookingForm.guestCount * bookedDays;
    }
}
