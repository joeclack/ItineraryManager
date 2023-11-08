package D3981791.phase_1;
import java.util.ArrayList;
import java.util.List;


public class Itinerary {
    public Attendee attendeeInst;
    public List<Activity> activitiesList;
    public List<ItineraryAddOn> itineraryAddOnsList;
    private String refNumber;
    private int totalCost;
    private int discount;
    

    public Itinerary(Attendee attendeeInst, List<Activity> activitiesList, ArrayList itineraryAddOnsList, String refNumber, int totalCost, int discount) {
        this.attendeeInst = attendeeInst;
        this.activitiesList = activitiesList;
        this.itineraryAddOnsList = itineraryAddOnsList;
        this.refNumber = refNumber;
        this.totalCost = totalCost;
        this.discount = discount;
    }


    public Attendee getAttendeeInst() {
        return attendeeInst;
    }

    public void setAttendeeInst(Attendee attendeeInst) {
        this.attendeeInst = attendeeInst;
    }

    public List<Activity> getActivitiesList() {
        return activitiesList;
    }

    public void setActivitiesList(List<Activity> activitiesList) {
        this.activitiesList = activitiesList;
    }

    public List<ItineraryAddOn> getItineraryAddOnsList() {
        return itineraryAddOnsList;
    }

    public void setItineraryAddOnsList(List<ItineraryAddOn> itineraryAddOnsList) {
        this.itineraryAddOnsList = itineraryAddOnsList;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    
}
