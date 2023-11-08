package D3981791.phase_2;


import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;


public class App {

    String separator = "---------------------------------";

    public Attendee createAttendee() {
        out.println(separator);
        out.println("Lead attendee details");

        String firstName = Errors.emptyInput("First name: ").toUpperCase();
        String lastName =  Errors.emptyInput("Last name: ").toUpperCase();
        int totalAttendees = Errors.intBetween("Total attendees: ", 3, 100);
        int totalActivities =  Errors.intBetween("Total activities: ", 1, 5);
        String date =  Errors.emptyInput("Date: ");

        return new Attendee(firstName, lastName, totalAttendees, totalActivities, date);
    }

    public void displayActivityChoices(String[] names) {
        for(int j = 0; j < names.length; j++) {
            out.println((j+1) + ". " + names[j]);
        }
        out.println("4. Custom");
    }

    public Activity createActivity(Attendee leadAttendee, int i) {
        out.println(separator);

        String[] titles = {"Bridge building", "Assault course", "Cookery class"};
        String[] descriptions = {"Building a bridge from paper in teams", "SAS style assault courses", "Cooking lessons"};
        String[] locations = {"Yorkshire", "In the woods somewhere", "In a kitchen"};
        int[] durations = {1, 2, 2};
        int[] baseCosts = {2000, 6000, 3000};
        String[] codes = {"BRI-01", "ACO-02", "COO-03"};

        String title;
        String description;
        String location;
        String time;
        int duration;
        int baseCost;
        String code;

        out.println("Activity " + (i + 1));

        displayActivityChoices(titles);

        int choice = Errors.intBetween("Choice: ", 1, 3);

        title = titles[choice - 1];
        description = descriptions[choice - 1];
        location = locations[choice - 1];
        time = Errors.emptyInput("Time: ");
        duration = durations[choice - 1];
        baseCost = baseCosts[choice - 1];
        code = codes[choice - 1];

        Activity newActivity = new Activity(title, description, location, time, duration, baseCost, createActivityAddOns(title));
        newActivity.setActivityCode(code);
        newActivity.setTotalActivityCost(newActivity.calculateTotalActivityCost(leadAttendee));

        return newActivity;
    }

    public List<ActivityAddOn> createActivityAddOns(String title) {
        ArrayList<ActivityAddOn> activityAddOnList = new ArrayList<>();

        String[] names = {"Travel", "Insurance", "Photography"};
        int[] costs = {400, 600, 500};
        String[] codes = {"TRV", "INS", "PHO"};

        String name;
        int cost;
        String code;

        int numberOfAddOns = Errors.intBetween("How many add ons are required for the " + title + " activity? ", 0, 3);

        int counter = 0;
        displayActivityChoices(names);

        while(counter <= numberOfAddOns-1) {

            int preMadeAddOn = Errors.intOnly("Choice: ");

            name = names[preMadeAddOn - 1];
            cost = costs[preMadeAddOn - 1];
            code = codes[preMadeAddOn - 1];


            ActivityAddOn newAddOn = new ActivityAddOn(name, cost);
            newAddOn.setCode(code);
            activityAddOnList.add(newAddOn);
            counter++;
        }

        return activityAddOnList;

    }

    public List<ItineraryAddOn> createItineraryAddOns() {
        ArrayList<ItineraryAddOn> itineraryAddOnsList = new ArrayList<>();

        String[] names = {"Accommodation", "Coffee/Tea breaks", "Lunch"};
        int[] costs = {9500, 200, 300};
        String[] codes = {"ACC", "CTB", "LCH"};

        String name;
        int cost;
        String code;

        int numberOfAddOns = Errors.intBetween("How many add ons are required for the itinerary? ", 0, 3);

        int counter = 0;
        displayActivityChoices(names);

        while(counter <= numberOfAddOns-1) {

            int preMadeAddOn = Errors.intOnly("Choice: ");

            name = names[preMadeAddOn - 1];
            cost = costs[preMadeAddOn - 1];
            code = codes[preMadeAddOn - 1];


            ItineraryAddOn newAddOn = new ItineraryAddOn(name, cost);
            newAddOn.setCode(code);
            itineraryAddOnsList.add(newAddOn);
            counter++;
        }

        return itineraryAddOnsList;

    }

}