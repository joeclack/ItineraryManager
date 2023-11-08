package D3981791.phase_3;

import static java.lang.System.out;

public class ItineraryOutput {

    public static void PrintItinerary(Itinerary itinerary) {



        out.println("|------------------------------------------------------|");
        out.print("| Client: " + itinerary.getAttendeeInst().getFirstName().charAt(0)+" "+ itinerary.getAttendeeInst().getLastName());
        out.println("                        Ref: " + itinerary.getRefNumber());
        out.println("| Date: " + itinerary.getAttendeeInst().getDate());


        String totalActivities;

        if(itinerary.getAttendeeInst().getTotalActivities()<=5) {
            totalActivities = Itinerary.NumberToWordConverter(itinerary.getAttendeeInst().getTotalActivities());
        } else {
            totalActivities = String.valueOf(itinerary.getAttendeeInst().getTotalActivities());
        }



        out.print("| Activities: " + totalActivities);

        String totalAttendees;

        if(itinerary.getAttendeeInst().getTotalAttendees()<=5) {
            totalAttendees = Itinerary.NumberToWordConverter(itinerary.getAttendeeInst().getTotalAttendees());
        } else {
            totalAttendees = String.valueOf(itinerary.getAttendeeInst().getTotalAttendees());
        }



        out.println("                        Attendees: " + totalAttendees); // Number of activities and attendees
        out.println("|                                                      |");


        out.println("|                                                      |");
        out.println("|               Cost breakdown                         |");
        out.println("|                                                      |");
        out.println("| Itinerary add ons:                                   |");

        int totalAttendeesInt = itinerary.getAttendeeInst().getTotalAttendees();

        if(!itinerary.getItineraryAddOnsList().isEmpty()) {
            int count = 0;
            while (count < itinerary.getItineraryAddOnsList().size()) {
                double itineraryAddonCostPounds = itinerary.getItineraryAddOnsList().get(count).getCost() / 100.0;
                out.println("|   Add on: " + itinerary.getItineraryAddOnsList().get(count).getName() + " @ £" + itineraryAddonCostPounds + " x " + totalAttendeesInt);
                count++;
            }
        } else {
            out.println("|    No add ons                                |");
        }
        out.println("|                                 Sub total: £" + itinerary.getTotalItineraryAddOnCost() / 100.0 + " |");


        out.println("|                                                      |");
        out.println("| Activities:                                          |");
        out.println("|                                                      |");

        if(!itinerary.getActivitiesList().isEmpty()) {
            int count = 0;

            while (count < itinerary.getActivitiesList().size()) {
                double activitiesCostPounds = itinerary.getActivitiesList().get(count).getBaseCost() / 100.0;
                out.println("| " + (count+1) + ". " + itinerary.getActivitiesList().get(count).getTitle() + " @ £" + activitiesCostPounds + " x " + totalAttendeesInt);

                int counter = 0;

                while(counter < itinerary.getActivitiesList().get(count).getActivityAddOnList().size()) {
                    if (!itinerary.getActivitiesList().get(count).getActivityAddOnList().isEmpty()) {
                        double activitiesAddOnCostPounds = itinerary.getActivitiesList().get(count).activityAddOnList.get(counter).getCost() / 100.0;
                        out.println("|   Add on: " + itinerary.getActivitiesList().get(count).activityAddOnList.get(counter).getName() + " @ £" + activitiesAddOnCostPounds + " x " + totalAttendeesInt);
                    } else {
                        out.println("|   No add ons                                         |");
                    }
                    counter++;
                }
                out.println("|                                         Sub total: £" + itinerary.getActivitiesList().get(count).getTotalActivityCost() / 100.0 + " |");
                count++;

            }
        } else {
            out.println("| No activities                                        |");
        }


        double totalCostPounds = itinerary.getTotalCost() / 100.0;
        double discountTotalPounds = (totalCostPounds * itinerary.getDiscount())/100.0;
        double grandTotalPounds = totalCostPounds-discountTotalPounds;

        out.println("|                                                      |");
        out.println("|                                                      |");
        out.println("|                                                      |");
        out.println("|                                             Total: £" + totalCostPounds + " |");
        out.println("|                            Discount applied ( " + itinerary.getDiscount() + "%) : £" + discountTotalPounds + " |");
        out.println("|                                                      |");
        out.println("|                                       Grand total: £" + grandTotalPounds + " |");
        out.println("|------------------------------------------------------|");



    }

}
