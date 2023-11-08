package D3981791.phase_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Files {

    public static void SaveToFile(Itinerary itinerary){
        // Each row of the file will represent 1 itinerary, where each field is separated by a tab.
        //•	Reference
        //•	Date
        //•	Attendee name
        //•	Total cost (in pence)
        //•	Total activities
        //•	Activities code (format 3 letter, hyphen, 2 digits)
        // 	Where add-ons have been selected, the activity code is followed colon and then a comma separated list of add-on codes, eg:
        //SWM-01:INS,TRN
        //
        //Where INS means insurance and TRN is the code for transport.  You are welcome to make up your own codes.

        String fileName = "itineraries.txt";

        String content = "Hello, World!"; // Content to be written to the file

        StringBuilder itineraryString = new StringBuilder();
        itineraryString.append(itinerary.getRefNumber())
                .append(", ")
                .append(itinerary.getAttendeeInst().getDate())
                .append(", ")
                .append(itinerary.getAttendeeInst().getFirstName())
                .append(" ")
                .append(itinerary.getAttendeeInst().getLastName())
                .append(", ")
                .append(itinerary.getTotalCost() - ((itinerary.getTotalCost() * ((itinerary.getDiscount())))/100))
                .append(", ")
                .append(itinerary.getAttendeeInst().getTotalActivities())
                .append(", ");

        int i = 0;
        int j = 0;

        for(Activity activity : itinerary.getActivitiesList()) {
            itineraryString.append(itinerary.getActivitiesList().get(i).getActivityCode())
                    .append(": ");
            for(ActivityAddOn addOn : itinerary.getActivitiesList().get(j).getActivityAddOnList()) {
                itineraryString.append(addOn.getCode())
                        .append(", ");
                j++;
            }
            i++;
        }





        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(String.valueOf(itineraryString)); // Write the content to the file
            System.out.println("Content has been written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }

    }
}
