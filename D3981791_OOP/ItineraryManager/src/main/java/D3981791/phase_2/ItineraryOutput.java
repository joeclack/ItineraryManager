package D3981791.phase_2;
import static java.lang.System.out;

public class ItineraryOutput {

    private ItineraryOutput() {

    }

    public static void printItinerary(Itinerary itinerary) {
        int totalActivities = itinerary.getAttendeeInst().getTotalActivities();
        int totalAttendees = itinerary.getAttendeeInst().getTotalAttendees();

        printHeader(itinerary);
        printTotalAttAct(itinerary, totalAttendees, totalActivities);
        printAddOns(itinerary, totalAttendees);
        printActivities(itinerary, totalAttendees);
        printTotalCost(itinerary);
    }

    static String emptyLine = "|                                                      |";
    static String topBottomBorder = "|------------------------------------------------------|";




    private static void printHeader(Itinerary itinerary) {
        out.println(topBottomBorder);
        out.println("| Client: " + itinerary.getAttendeeInst().getFirstName().charAt(0) + " " +
                itinerary.getAttendeeInst().getLastName() + "                        Ref: " + itinerary.getRefNumber());
        out.println("| Date: " + itinerary.getAttendeeInst().getDate());
    }

    private static void printTotalAttAct(Itinerary itinerary, int totalAttendees, int totalActivities) {

        out.println("| Activities: " + itinerary.numberToWordConverter(totalActivities) +
                "                        Attendees: " + itinerary.numberToWordConverter(totalAttendees));
        out.println(emptyLine);
    }

    private static void printAddOns(Itinerary itinerary, int totalAttendees) {
        out.println("Itinerary add ons: ");
        if (!itinerary.getItineraryAddOnsList().isEmpty()) {
            for (ItineraryAddOn addOn : itinerary.getItineraryAddOnsList()) {
                double addOnCostPounds = addOn.getCost() / 100.0;
                out.println("|   Add on: " + addOn.getName() + " @ £" + addOnCostPounds + " x " + totalAttendees);
            }
        } else {
            out.println("|    No add ons                                |");
        }
        out.println("|                                 Sub total: £" + itinerary.getTotalItineraryAddOnCost() / 100.0 + " |");
        out.println(emptyLine);
    }

    private static void printActivities(Itinerary itinerary, int totalAttendees) {
        out.println("Activities");
        if (!itinerary.getActivitiesList().isEmpty()) {
            int count = 1;
            for (Activity activity : itinerary.getActivitiesList()) {
                double activityCostPounds = activity.getBaseCost() / 100.0;
                out.println("| " + count + ". " + activity.getTitle() + " @ £" + activityCostPounds + " x " + totalAttendees);
                if (!activity.getActivityAddOnList().isEmpty()) {
                    for (ActivityAddOn addOn : activity.getActivityAddOnList()) {
                        double addOnCostPounds = addOn.getCost() / 100.0;
                        out.println("|   Add on: " + addOn.getName() + " @ £" + addOnCostPounds + " x " + totalAttendees);
                    }
                } else {
                    out.println("|   No add ons                                         |");
                }
                out.println("|                                         Sub total: £" + activity.getTotalActivityCost() / 100.0 + " |");
                count++;
            }
        } else {
            out.println("| No activities                                        |");
        }
    }

    private static void printTotalCost(Itinerary itinerary) {
        double totalCostPounds = itinerary.getTotalCost() / 100.0;
        double discountTotalPounds = (totalCostPounds * itinerary.getDiscount()) / 100.0;
        double grandTotalPounds = totalCostPounds - discountTotalPounds;

        out.println(emptyLine);
        out.println(emptyLine);
        out.println(emptyLine);
        out.println("|                                             Total: £" + totalCostPounds + " |");
        out.println("|                            Discount applied (" + itinerary.getDiscount() + "%) : £" + discountTotalPounds + " |");
        out.println(emptyLine);
        out.println("|                                       Grand total: £" + grandTotalPounds + " |");
        out.println(emptyLine);
        out.println(topBottomBorder);
    }
}
