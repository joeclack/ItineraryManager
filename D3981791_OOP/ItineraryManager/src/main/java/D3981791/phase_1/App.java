package D3981791.phase_1;
import java.util.ArrayList;
import java.util.Scanner;


public class App {


    public Itinerary CreateItinerary() {


        Scanner scanner = new Scanner(System.in);

        Attendee leadAttendee = new Attendee("Joe", "Clack", 6, "12/12/12", 2);
        ArrayList<ActivityAddOn> activityAddOnList = new ArrayList<>();

        ActivityAddOn newAddOn1 = new ActivityAddOn("Transport", 1000);
        ActivityAddOn newAddOn2 = new ActivityAddOn("Transport", 1500);

        activityAddOnList.add(newAddOn1);
        activityAddOnList.add(newAddOn2);

        Activity newActivity = new Activity("Scuba", "Scuba diving in the sea", "italy", "10am", 2, 10000, activityAddOnList);


        int addOnTotal=0;

        for (ActivityAddOn activityAddOn : activityAddOnList) {
            addOnTotal += ((AddOn) activityAddOn).getCost() * leadAttendee.getTotalAttendees();
        }

        newActivity.setTotalActivityCost(((addOnTotal)+(newActivity.getBaseCost()*leadAttendee.getTotalAttendees()))/100);


        ArrayList<Activity> activitiesList = new ArrayList<>();
        activitiesList.add(newActivity);
        activitiesList.add(newActivity);


        ArrayList<ItineraryAddOn> itineraryAddOnsList = new ArrayList<>();

        int totalCost = 0;

        for (Activity activity : activitiesList) {
            totalCost += ((Activity) activity).getTotalActivityCost();
        }

        return new Itinerary(leadAttendee, activitiesList, itineraryAddOnsList, "JC123A", totalCost, 5);


    }


}