package D3981791.phase_2;

import java.util.List;
import java.util.Random;


public class Itinerary {


    private Attendee attendeeInst;
    private List<Activity> activitiesList;
    private List<ItineraryAddOn> itineraryAddOnsList;
    private String refNumber;
    private int totalCost;
    private int discount;
    private int totalItineraryAddOnCost;
    private String totalAttendeesWord;
    private String getTotalActivitiesWord;
    private int grandTotal;
    private Random random = new Random();

    public Itinerary(Attendee attendeeInst, List<Activity> activitiesList, List<ItineraryAddOn> itineraryAddOnsList) {
        this.attendeeInst = attendeeInst;
        this.activitiesList = activitiesList;
        this.itineraryAddOnsList = itineraryAddOnsList;
    }




    public int calculateItineraryAddOnCost(Attendee leadAttendee) {

        int itineraryAddOnTotal = 0;

        for (ItineraryAddOn itineraryAddOn : itineraryAddOnsList)
            itineraryAddOnTotal += itineraryAddOn.getCost() * leadAttendee.getTotalAttendees();

        return itineraryAddOnTotal;
    }

    public int calculateTotal(Attendee leadAttendee) {

        int activityTotal = 0;
        int itineraryAddOnTotal = 0;

        for (ItineraryAddOn itineraryAddOn : itineraryAddOnsList)
            itineraryAddOnTotal += itineraryAddOn.getCost()* leadAttendee.getTotalAttendees();

        for (Activity activity : activitiesList)
            activityTotal += activity.getTotalActivityCost();

        return activityTotal + itineraryAddOnTotal;

    }

    public String numberToWordConverter(int numToConvert) {

        String wordVersionNumber = "";

        String[] onesDictionary = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] teensDictionary = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tensDictionary = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String numAsString = String.valueOf(numToConvert);

        int length = numAsString.length();

        if (length == 1) {

            int index = numToConvert - 1;

            wordVersionNumber = onesDictionary[index];

        } else if (length == 2) {


            if(numToConvert >=10 && numToConvert < 20) {

                int secondDigit = Character.getNumericValue(numAsString.charAt(1));

                wordVersionNumber = teensDictionary[secondDigit];
            }

            else {

                int firstDigit = Character.getNumericValue(numAsString.charAt(0));
                int secondDigit = Character.getNumericValue(numAsString.charAt(1));

                wordVersionNumber = tensDictionary[firstDigit-2] + " " + onesDictionary[secondDigit-1];
            }
        }

        return wordVersionNumber;
    }

    public String generateRefNum(Attendee leadAttendee) {


        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int threeNums = this.random.nextInt(999) + 100;
        int randLetterIndex = this.random.nextInt(alphabet.length());
        char lastChar = alphabet.charAt(randLetterIndex);

        return String.valueOf(leadAttendee.getFirstName().charAt(0)) + String.valueOf(leadAttendee.getLastName().charAt(0)) + threeNums + lastChar;
    }

    public int calculateDiscount(Attendee leadAttendee) {

        int[][] discountTable = {
                {0, 5, 8},
                {5, 8, 12},
                {10, 12, 14}
        };

        int activities = leadAttendee.getTotalActivities();
        int attendees = leadAttendee.getTotalAttendees();


        int rowIndex;
        int colIndex;
        if (activities >= 1 && activities <= 2) {
            colIndex = 0;
        } else if (activities <= 5) {
            colIndex = 1;
        } else {
            colIndex = 2;
        }

        if (attendees < 10) {
            rowIndex = 0;
        } else if (attendees <= 20) {
            rowIndex = 1;
        } else {
            rowIndex = 2;
        }

        return discountTable[colIndex][rowIndex];
    }


    public String getTotalAttendeesWord() {
        return totalAttendeesWord;
    }

    public void setTotalAttendeesWord(String totalAttendeesWord) {
        this.totalAttendeesWord = totalAttendeesWord;
    }

    public String getGetTotalActivitiesWord() {
        return getTotalActivitiesWord;
    }

    public void setGetTotalActivitiesWord(String getTotalActivitiesWord) {
        this.getTotalActivitiesWord = getTotalActivitiesWord;
    }

    public Attendee getAttendeeInst() {
        return attendeeInst;
    }

    public void setAttendeeInst(Attendee attendeeInst) {
        this.attendeeInst = attendeeInst;
    }

    public int getTotalItineraryAddOnCost() {
        return totalItineraryAddOnCost;
    }

    public void setTotalItineraryAddOnCost(int totalItineraryAddOnCost) {
        this.totalItineraryAddOnCost = totalItineraryAddOnCost;
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

    public int getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }
}
