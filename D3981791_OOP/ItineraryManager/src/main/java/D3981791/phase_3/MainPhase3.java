package D3981791.phase_3;

import java.util.ArrayList;

import static java.lang.System.exit;
import static java.lang.System.out;


public class MainPhase3 {


    public static void main(String[] args) {

        Itinerary itinerary = null;


        out.println("1. New itinerary");
        out.println("2. Manage");
        out.println("3. Exit");

        switch (Errors.IntOnly("Choice: ")) {
            case 1:
                out.println();
                itinerary = getItinerary();
                break;
            case 2:
                out.println("Currently unavailable");
                exit(0);
            case 3:
                out.println("Closing application...");
                exit(0);
        }


        assert itinerary != null;
        Files.SaveToFile(itinerary);
        switch (Errors.EmptyInput("Do you want to print the itinerary? (yes/no): ")) {
            case "yes":
                out.println("Generating itinerary...");
                out.println();
                ItineraryOutput.PrintItinerary(itinerary);
                break;
            case "no":
                out.println("Goodbye");
                exit(1);
        }
    }


    private static Itinerary getItinerary() {
        App app = new App();

        Attendee leadAttendee = app.CreateAttendee();

        ArrayList<Activity> activitiesList = new ArrayList<>();
        int i = 0;
        while (i < leadAttendee.getTotalActivities()) {
            Activity activity = app.CreateActivity(leadAttendee, i);
            activitiesList.add(activity);
            i++;
        }

        ArrayList<ItineraryAddOn> itineraryAddOnsList = app.CreateItineraryAddOns();
        return app.CreateItinerary(leadAttendee, activitiesList, itineraryAddOnsList);
    }
}
