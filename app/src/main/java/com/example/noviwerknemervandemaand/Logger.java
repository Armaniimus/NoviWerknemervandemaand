package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Logger {
    private int activityID;
    public Logger(int activityID) {
        this.activityID = activityID;
    }

    public void switchActivity(int newActivityID) {
        String msg = "CurrentActivityID: " + this.activityID + "==> NewActivityID: " + newActivityID;
        Log.v("switchView", msg);
    }

    public void toastShow(Context context,  CharSequence text) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
