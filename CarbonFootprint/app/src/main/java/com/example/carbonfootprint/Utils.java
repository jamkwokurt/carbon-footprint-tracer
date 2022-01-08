package com.example.carbonfootprint;

import android.service.autofill.UserData;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private static Utils instance;
    private static Map<User,TravelRecord> travelRecords;

    private Utils(){
        if(travelRecords == null){
            travelRecords = new HashMap<>();
        }else{
        }
    }

    public static Utils getInstance(){
        if(instance == null){
            instance = new Utils();
            return instance;
        }else{
            return instance;
        }
    }

    public static Map<User, TravelRecord> getTravelRecords() {
        return travelRecords;
    }

    public static void setTravelRecords(Map<User, TravelRecord> travelRecords) {
        Utils.travelRecords = travelRecords;
    }
}
