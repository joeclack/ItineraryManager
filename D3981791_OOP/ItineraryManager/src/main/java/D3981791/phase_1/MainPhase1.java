package D3981791.phase_1;


public class MainPhase1 {


    public static void main(String[] args) {


        App app = new App();
        
        Itinerary itinerary = app.CreateItinerary();
        
        
        double subTotal = 0;
        

        System.out.println("|------------------------------------------------------|");

        System.out.print("| Client: " + itinerary.attendeeInst.getFirstName().charAt(0)+" "+itinerary.attendeeInst.getLastName());
        System.out.println("                        Ref: " + itinerary.getRefNumber() + "   |"); //Name and ref line
        System.out.println("| Date: " + itinerary.attendeeInst.getDate() + "                                       |"); // Date line
        System.out.print("| Activities: " + itinerary.attendeeInst.getTotalActivities());
        System.out.println("                        Attendees: " + itinerary.getAttendeeInst().getTotalAttendees() + "    |"); // Number of activities and attendees
        System.out.println("|                                                      |");

        
        System.out.println("|                                                      |");
        System.out.println("|                     Cost breakdown                   |");
        System.out.println("|                                                      |");
        System.out.println("| Itinerary add ons:                                   |");
        System.out.println("|                                                      |");
        System.out.println("| Activities:                                          |");
        System.out.println("|                                                      |");
        
        
        for(int i = 0; i < itinerary.getActivitiesList().size(); i ++) {


            Activity a = (Activity) itinerary.activitiesList.get(i);
            
            int totalAttendees = itinerary.attendeeInst.getTotalAttendees();
            
            System.out.println("| " + (i+1) +". "+ a.getTitle() + " @ £" + a.getBaseCost()/100 + " x " + totalAttendees + "                                  |");

            for(int j = 0; j < itinerary.getActivitiesList().size(); j++) {
                
                System.out.println("|   Add on: " + itinerary.activitiesList.get(j).activityAddOnList.get(j).getName() + " @ £" 
                        + itinerary.activitiesList.get(j).activityAddOnList.get(j).getCost()/100 + " x " + totalAttendees + "                        |");
                
            }

            subTotal = a.getTotalActivityCost();

            System.out.println("|                                 Sub total: £" + subTotal + "    |");


        }


        double totalCost = itinerary.getTotalCost();
        int discountPercentage = itinerary.getDiscount();
        double discountTotal = totalCost * discountPercentage/100;


        System.out.println("|                                                      |");
        System.out.println("|                                                      |");
        System.out.println("|                                                      |");
        System.out.println("|                                     Total: £" + totalCost + "   |");
        System.out.println("|                    Discount applied ("+ discountPercentage + "%) : £" + discountTotal + "     |");
        System.out.println("|                                                      |");
        System.out.println("|                               Grand total: £" + (totalCost-discountTotal) + "   |");
        System.out.println("|------------------------------------------------------|");


    }


}
