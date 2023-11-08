package D3981791.phase_2;

import java.util.ArrayList;
import java.util.List;


public class MainPhase2 {

    private static Itinerary generateItinerary() {
        App app = new App();

        Attendee leadAttendee = app.createAttendee();

        ArrayList<Activity> activitiesList = new ArrayList<>();
        int i = 0;
        while (i < leadAttendee.getTotalActivities()) {
            Activity activity = app.createActivity(leadAttendee, i);
            activitiesList.add(activity);
            i++;
        }

        List<ItineraryAddOn> itineraryAddOnsList = app.createItineraryAddOns();

        Itinerary itinerary = new Itinerary(leadAttendee, activitiesList, itineraryAddOnsList);

        itinerary.setRefNumber(itinerary.generateRefNum(leadAttendee));
        itinerary.setDiscount(itinerary.calculateDiscount(leadAttendee));

        itinerary.setTotalItineraryAddOnCost(itinerary.calculateItineraryAddOnCost(leadAttendee));

        itinerary.setTotalCost(itinerary.calculateTotal(leadAttendee));
        return itinerary;
    }

    public static void main(String[] args) {

        ItineraryOutput.printItinerary(generateItinerary());
    }
}
