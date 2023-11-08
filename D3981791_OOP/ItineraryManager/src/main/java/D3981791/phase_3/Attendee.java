package D3981791.phase_3;


public class Attendee {


    private String firstName;
    private String lastName;
    private int totalAttendees;
    private int totalActivities;
    private String date;


    public Attendee(String firstName, String lastName, int totalAttendees, int totalActivities, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalAttendees = totalAttendees;
        this.date = date;
        this.totalActivities = totalActivities;
    }


    public void setTotalActivities(int totalActivities) {
        this.totalActivities = totalActivities;
    }

    public int getTotalActivities() {
        return totalActivities;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTotalAttendees() {
        return totalAttendees;
    }

    public String getDate() {
        return date;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTotalAttendees(int totalAttendees) {
        this.totalAttendees = totalAttendees;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
