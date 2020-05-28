package com.example.noviwerknemervandemaand;

import android.util.Log;
import android.view.View;

public class Tab3SelectNHandle_Model {
    private View currentView = null;

    public void select(View view) {
        View oldView = this.currentView;
        this.currentView = view;

        if (oldView != null) {
            oldView.setBackgroundResource(0);

            Log.v("oldView", oldView.toString());
            Log.v("newView", view.toString());
        }

        this.currentView.setBackgroundResource(R.drawable.selected_border);
    }
}
