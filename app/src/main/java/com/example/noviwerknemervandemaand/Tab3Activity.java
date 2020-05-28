package com.example.noviwerknemervandemaand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLConnection;

public class Tab3Activity extends AppCompatActivity {
    private Tab3GridView_Model Tab3GridView_Model = null;
    private Logger logger = new Logger(3);
    private Tab3SelectNHandle_Model SelectNHandle_Model = new Tab3SelectNHandle_Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        LinearLayout Main_View =  (LinearLayout) findViewById(R.id.Main_view);
        this.Tab3GridView_Model = new Tab3GridView_Model(cw, Main_View, this);
        this.Tab3GridView_Model.run(SelectNHandle_Model);
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
        Bitmap bitmap = SelectNHandle_Model.getBitmap();
        try {
            // create file object
            File file = new File(this.getExternalCacheDir(),"noviWerknemerVanDeMaand.png");

            // Write File
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);

            // create and launch share intent
            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Werknemer van de maand");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/png");
            startActivity(Intent.createChooser(intent, "Share image via"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
