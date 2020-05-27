package com.example.noviwerknemervandemaand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;

import java.io.File;
import java.util.ArrayList;

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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickTab2(android.view.View view) {
        this.logger.switchActivity(2);
        Intent intent = new Intent(this, Tab2Activity.class);
        startActivity(intent);
    }

    public void clickFotoVerzenden(android.view.View view) {
        Log.v("Tab3Activity", "start clickFotoVerzenden");
    }

    public void clickFotoBekijken(android.view.View view) {
        Log.v("Tab3Activity", "start clickFotoBekijken");
    }
}
