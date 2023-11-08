package D3981791.phase_2;

import java.util.List;


public class Activity {


    private String title;
    private String description;
    private String location;
    private String time;
    private int duration;
    private int baseCost;
    private List <ActivityAddOn> activityAddOnList;
    private int totalActivityCost;
    private String activityCode;


    public Activity(String title, String description, String location, String time, int duration, int baseCost, List<ActivityAddOn> activityAddOnList) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.time = time;
        this.duration = duration;
        this.baseCost = baseCost;
        this.activityAddOnList = activityAddOnList;
    }


    public int calculateTotalActivityCost(Attendee leadAttendee) {

        int activityAddOnTotal = 0;

        for (ActivityAddOn activityAddOn : activityAddOnList)
            activityAddOnTotal += activityAddOn.getCost() * leadAttendee.getTotalAttendees();


        return (this.baseCost* leadAttendee.getTotalAttendees()) + activityAddOnTotal;

    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(int baseCost) {
        this.baseCost = baseCost;
    }

    public List<ActivityAddOn> getActivityAddOnList() {
        return activityAddOnList;
    }

    public void setActivityAddOnList(List<ActivityAddOn> activityAddOnList) {
        this.activityAddOnList = activityAddOnList;
    }

    public int getTotalActivityCost() {
        return totalActivityCost;
    }

    public void setTotalActivityCost(int totalActivityCost) {
        this.totalActivityCost = totalActivityCost;
    }


}