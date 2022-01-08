package com.example.carbonfootprint;

import java.sql.Time;
import java.util.Date;

public class TravelRecord {
    private User user;
    private String way_of_travel;
    private Date date_of_travel;
    private Time time_of_travel;

    public TravelRecord(User user) {
        this.user = user;
    }

    public TravelRecord(User user, String way_of_travel, Date date_of_travel, Time time_of_travel) {
        this.user = user;
        this.way_of_travel = way_of_travel;
        this.date_of_travel = date_of_travel;
        this.time_of_travel = time_of_travel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getWay_of_travel() {
        return way_of_travel;
    }

    public void setWay_of_travel(String way_of_travel) {
        this.way_of_travel = way_of_travel;
    }

    public Date getDate_of_travel() {
        return date_of_travel;
    }

    public void setDate_of_travel(Date date_of_travel) {
        this.date_of_travel = date_of_travel;
    }

    public Time getTime_of_travel() {
        return time_of_travel;
    }

    public void setTime_of_travel(Time time_of_travel) {
        this.time_of_travel = time_of_travel;
    }

    @Override
    public String toString() {
        return "user_name=" + user.getUsername() +
                ", user_email='" + user.getEmail() +
                ", way_of_travel='" + way_of_travel +
                ", way_of_travel='" + way_of_travel +
                ", date_of_travel=" + date_of_travel +
                ", time_of_travel=" + time_of_travel +
                '}';
    }
}
