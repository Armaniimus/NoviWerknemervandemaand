package com.example.noviwerknemervandemaand;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class Tab3Activity extends AppCompatActivity {
    private Tab3GridView_Model Tab3GridView_Model = null;
    private Logger logger = new Logger(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        LinearLayout Main_View =  (LinearLayout) findViewById(R.id.Main_view);
        Tab3GridView_Model Tab3GridView_Model = new Tab3GridView_Model(cw, Main_View, this);
        Tab3GridView_Model.run();
    }

    public void clickTab1(android.view.View view) {
        this.logger.switchActivity(1);
        this.logger.toastShow(getApplicationContext(), "Switching to Tab1");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickTab2(android.view.View view) {
        this.logger.switchActivity(2);
        this.logger.toastShow(getApplicationContext(), "Switching to Tab2");

        Intent intent = new Intent(this, Tab2Activity.class);
        startActivity(intent);
    }

    public void clickFotoVerzenden(android.view.View view) {
        Log.v("Tab3Activity", "start clickFotoVerzenden");

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    public void clickFotoBekijken(android.view.View view) {
        Log.v("Tab3Activity", "start clickFotoBekijken");
    }
}
