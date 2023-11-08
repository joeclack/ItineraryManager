package D3981791.phase_3;


import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class App {

    Scanner scanner = new Scanner(in);

    public Attendee CreateAttendee() {

        out.println("Lead attendee details");
        out.println("=======================");

        String firstName = Errors.EmptyInput("First name: ").toUpperCase();
        out.println("=======================");

        String lastName =  Errors.EmptyInput("Last name: ").toUpperCase();
        out.println("=======================");

        int totalAttendees = Errors.IntOnly("Total attendees: ");
        out.println("=======================");
        while(totalAttendees<3 | totalAttendees>100) {
            out.println("Invalid number. Minimum: 3 Maximum: 100");
            totalAttendees =  Errors.IntOnly("Total attendees: ");
            out.println("=======================");
        }


        int totalActivities =  Errors.IntOnly("Total activities: ");
        out.println("=======================");
        while(totalActivities<1 | totalActivities>5) {
            out.println("Invalid number. Minimum: 1 Maximum: 5");
            totalActivities =  Errors.IntOnly("Total activities: ");
            out.println("=======================");
        }

        String date =  Errors.EmptyInput("Date: ");
        out.println("=======================");

        Attendee leadAttendee = new Attendee(firstName, lastName, totalAttendees, totalActivities, date);

        out.println();

        return leadAttendee;
    }

    public Activity CreateActivity(Attendee leadAttendee, int i) {

        Activity newActivity = null;

        String[] titles = {"Bridge building", "Assault course", "Cookery class"};
        String[] descriptions = {"Building a bridge from paper in teams", "SAS style assault courses", "Cooking lessons"};
        String[] locations = {"Yorkshire", "In the woods somewhere", "In a kitchen"};
        int[] durations = {1, 2, 2};
        int[] baseCosts = {2000, 6000, 3000};
        String time;
        String[] codes = {"BRI-01", "ACO-02", "COO-03"};


        out.println("---------------------------------");
        out.println("Activity " + (i + 1));

        for(int j = 0; j < titles.length; j++) {
            out.println((j+1) + ". " + titles[j]);
        }
        out.println("4. Custom");

        boolean validChoice = false;

        while (!validChoice) {
            int preMadeActivity = Errors.IntOnly("Choice: ");

            switch (preMadeActivity) {
                case 1:
                case 2:
                case 3:
                    time = Errors.EmptyInput("Time: ");
                    newActivity = new Activity((titles[preMadeActivity - 1]),
                            (descriptions[preMadeActivity - 1]),
                            (locations[preMadeActivity - 1]),
                            time,
                            (durations[preMadeActivity - 1]),
                            (baseCosts[preMadeActivity - 1]),
                            (CreateActivityAddOns(titles[preMadeActivity - 1])));

                    newActivity.setActivityCode(codes[preMadeActivity-1]);
                    newActivity.setTotalActivityCost(newActivity.calculateTotalActivityCost(leadAttendee));

                    validChoice = true;

                    break;
                case 4:
                    String title = Errors.EmptyInput("Title: ");
                    String description = Errors.EmptyInput("Description: ");
                    String location = Errors.EmptyInput("Location: ");
                    time = Errors.EmptyInput("Time: ");

                    int duration = Errors.IntOnly("Duration: ");
                    int baseCost = Errors.IntOnly("Base cost: ");

                    out.println();


                    newActivity = new Activity(title, description, location, time, duration, baseCost, CreateActivityAddOns(title));

                    newActivity.setTotalActivityCost(newActivity.calculateTotalActivityCost(leadAttendee));

                    validChoice = true;

                    break;
                default:
                    out.println("Invalid option... try again");

                    break;
            }
        }
        return newActivity;
    };

    public ArrayList<ActivityAddOn> CreateActivityAddOns(String title) {

        ArrayList<ActivityAddOn> activityAddOnList = new ArrayList<>();
        ActivityAddOn newAddOn = null;

        String[] names = {"Travel", "Insurance", "Photography"};
        int[] costs = {400, 600, 500};
        String[] codes = {"TRV", "INS", "PHO"};

        int numberOfAddOns = Errors.IntOnly("How many add ons are required for the " + title + " activity? ");

        if(numberOfAddOns>0) {
            int counter = 0;



            out.println("---------------------------------");
            out.println("Add on");
            out.println("Choose from the list below of available add ons, or create a custom add on");
            for(int j = 0; j < names.length; j++) {
                out.println((j+1) + ". " + names[j]);
            }
            out.println("4. Custom");

            while(counter <= numberOfAddOns-1) {


                boolean validChoice = false;

                while (!validChoice) {
                    int preMadeAddOn = Errors.IntOnly("Choice: ");

                    switch (preMadeAddOn) {
                        case 1:
                        case 2:
                        case 3:
                            newAddOn = new ActivityAddOn((names[preMadeAddOn - 1]),
                                    (costs[preMadeAddOn - 1]));
                            newAddOn.setCode(codes[preMadeAddOn-1]);
                            activityAddOnList.add(newAddOn);
                            validChoice = true;
                            break;
                        case 4:
                            String name = Errors.EmptyInput("Name: ");
                            int cost = Errors.IntOnly("Cost: ");
                            out.println();
                            newAddOn = new ActivityAddOn(name, cost);
                            activityAddOnList.add(newAddOn);
                            validChoice = true;
                            break;
                        default:
                            out.println("Invalid option... try again");
                            break;
                    }
                    counter++;
                }
            }
        }  /* else {
            out.println("0 add-ons were added...");
        } */

        return activityAddOnList;

    }

    public ArrayList<ItineraryAddOn> CreateItineraryAddOns() {

        ArrayList<ItineraryAddOn> itineraryAddOnsList = new ArrayList<>();
        ItineraryAddOn newAddOn = null;

        String[] names = {"Accommodation", "Coffee/Tea breaks", "Lunch"};
        int[] costs = {9500, 200, 300};
        String[] codes = {"ACC", "CTB", "LCH"};

        int numberOfAddOns = Errors.IntOnly("How many add ons are required for the itinerary? ");

        if(numberOfAddOns>0) {
            int counter = 0;



            out.println("---------------------------------");
            out.println("Add on");
            out.println("Choose from the list below of available add ons, or create a custom add on");
            for(int j = 0; j < names.length; j++) {
                out.println((j+1) + ". " + names[j]);
            }
            out.println("4. Custom");

            while(counter <= numberOfAddOns-1) {


                boolean validChoice = false;

                while (!validChoice) {
                    int preMadeAddOn = Errors.IntOnly("Choice: ");

                    switch (preMadeAddOn) {
                        case 1:
                        case 2:
                        case 3:
                            newAddOn = new ItineraryAddOn((names[preMadeAddOn - 1]),
                                    (costs[preMadeAddOn - 1]));
                            newAddOn.setCode(codes[preMadeAddOn-1]);
                            itineraryAddOnsList.add(newAddOn);
                            validChoice = true;
                            break;
                        case 4:
                            String name = Errors.EmptyInput("Name: ");
                            int cost = Errors.IntOnly("Cost: ");
                            out.println();
                            newAddOn = new ItineraryAddOn(name, cost);
                            itineraryAddOnsList.add(newAddOn);
                            validChoice = true;
                            break;
                        default:
                            out.println("Invalid option... try again");
                            break;
                    }
                    counter++;
                }
            }
        } /* else {
            out.println("0 add-ons were added...");
        } */

        return itineraryAddOnsList;
    };

    public Itinerary CreateItinerary(Attendee leadAttendee, ArrayList<Activity> activitiesList, ArrayList<ItineraryAddOn> itineraryAddOnsList) {

        Itinerary itinerary = new Itinerary(leadAttendee, activitiesList, itineraryAddOnsList, Itinerary.GenerateRefNum(leadAttendee), Itinerary.CalculateDiscount(leadAttendee));

        itinerary.setTotalItineraryAddOnCost(itinerary.CalculateItineraryAddOnCost(leadAttendee));

        itinerary.setTotalCost(itinerary.CalculateTotal(leadAttendee));


        return itinerary;
    }


}