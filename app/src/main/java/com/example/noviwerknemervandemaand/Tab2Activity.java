package com.example.noviwerknemervandemaand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

public class Tab2Activity extends AppCompatActivity {
    private ImgHandler ImgHandler = new ImgHandler();
    private Logger logger = new Logger(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        ImageView imgView = (ImageView) findViewById(R.id.mainImgView);;
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("tmpImgDir", Context.MODE_PRIVATE);
        File file = new File(directory, "img" + ".jpg");

        if (file.exists()) {
            Bitmap bm = BitmapFactory.decodeFile(file.toString());
            Log.v( "Tab2Activity", "bm width: "+ bm.getWidth());
            Log.v( "Tab2Activity", "bm height:"+ bm.getHeight());
            imgView.setImageBitmap(bm);
        }

        this.setText();
    }

    public void setText() {
        TextView employeeText = (TextView) findViewById(R.id.medewerkerText);
        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy");
        String dateString = sdf.format(date);
        employeeText.setText("Novi medeWerker van de maand " + dateString);
    }

    public void clickTab1(android.view.View view) {
        this.logger.switchActivity(1);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickTab3(android.view.View view) {
        this.logger.switchActivity(3);
        Intent intent = new Intent(this, Tab3Activity.class);
        startActivity(intent);
    }
    public void clickTab3() {
        this.logger.switchActivity(3);
        Intent intent = new Intent(this, Tab3Activity.class);
        startActivity(intent);
    }

    public void clickRain(android.view.View view) {
        Log.v("Tabs2Activity", "start clickRain" );
        ImageView img = (ImageView)findViewById(R.id.rainView);
        toggleImgVisibility(img, view);
    }

    public void clickStar(android.view.View view) {
        Log.v("Tabs2Activity", "start clickStar" );
        ImageView img = (ImageView)findViewById(R.id.starView);
        toggleImgVisibility(img, view);
    }

    public void clickSun(android.view.View view) {
        Log.v("Tabs2Activity", "start clickSun" );
        ImageView img = (ImageView)findViewById(R.id.sunView);
        toggleImgVisibility(img, view);
    }

    public void clickThumbup(android.view.View view) {
        Log.v("Tabs2Activity", "start clickThumbup" );
        ImageView img = (ImageView)findViewById(R.id.thumbupView);
        toggleImgVisibility(img, view);
    }

    public void clickThunder(android.view.View view) {
        Log.v("Tabs2Activity", "start clickThunder" );
        ImageView img = (ImageView)findViewById(R.id.thunderView);
        toggleImgVisibility(img, view);
    }

    public void toggleImgVisibility(ImageView img, android.view.View view) {
        //Init Method
        Log.v("Tabs2Activity", "start toggleImgVisibility" );
        int visibility = img.getVisibility();
        Log.v("Tabs2Activity", "toggleImgVisibility visibility == " + visibility );

        //Toggle visibility
        if( visibility != view.VISIBLE ) {
            img.setVisibility(view.VISIBLE);
            Log.v("Tabs2Activity", "toggleImgVisibility changed to " + View.VISIBLE );
        } else {
            img.setVisibility(view.INVISIBLE);
            Log.v("Tabs2Activity", "toggleImgVisibility changed to " + view.INVISIBLE );
        }
    }

    public void clickStoreImg(View view) {
        // init Variables
        Log.v("Tabs2Activity", "start clickStoreImg" );

        Bitmap bm = null;
        FrameLayout img = (FrameLayout) findViewById(R.id.FrameMainImgView);
        FileOutputStream fos = null;

        try {
            img.setDrawingCacheEnabled(true);
            img.buildDrawingCache();
            bm = img.getDrawingCache();
        } catch (Exception E) {
            Log.e("BitmapError", "" + E);
            return;
        }

        try {
            // create path name
            Long tsLong = System.currentTimeMillis()/1000;
            String ts = tsLong.toString();
            ContextWrapper cw = new ContextWrapper(getApplicationContext());
            File directory = cw.getDir("permImgDir", Context.MODE_PRIVATE);

            // create file object
            File f = new File(directory, "img_" + ts + ".jpg");
            Log.d("filepath", f.toString());

            //try to write file
            try {
                fos = new FileOutputStream(f);
                bm.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();

                Log.d("FileSuccess", "File has been written succesfully");
            } catch (Exception e) {
                Log.e("FilewriteError", "" + e);
                return;
            }


        } catch (Exception E) {
            Log.e("BitmapError", "" + E);
            return;
        }

        this.clickTab3();
    }


}
