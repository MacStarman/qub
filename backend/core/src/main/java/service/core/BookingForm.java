package service.core;

import java.util.Date;

public class BookingForm {
    public String location;
    public Date startDate;
    public Date endDate;
    public int persons;

    public Date getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public int getPersons() {
        return persons;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
}
