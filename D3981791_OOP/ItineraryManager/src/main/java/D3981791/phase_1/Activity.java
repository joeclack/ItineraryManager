package D3981791.phase_1;
import java.util.List;


class Activity {


    private String title;
    private String description;
    private String location;
    private String time;
    private int duration;
    private int baseCost;    
    public List <ActivityAddOn> activityAddOnList;
    private int totalActivityCost;


    public Activity(String title, String description, String location, String time, int duration, int baseCost, List<ActivityAddOn> activityAddOnList) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.time = time;
        this.duration = duration;
        this.baseCost = baseCost;
        this.activityAddOnList = activityAddOnList;
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