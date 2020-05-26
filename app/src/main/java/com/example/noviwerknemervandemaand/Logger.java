package com.example.noviwerknemervandemaand;

import android.util.Log;

public class Logger {
    private int activityID;
    public Logger(int activityID) {
        this.activityID = activityID;
    }

    public void switchActivity(int newActivityID) {
        String msg = "CurrentActivityID: " + this.activityID + "==> NewActivityID: " + newActivityID;
        Log.v("switchView", msg);
    }
}
