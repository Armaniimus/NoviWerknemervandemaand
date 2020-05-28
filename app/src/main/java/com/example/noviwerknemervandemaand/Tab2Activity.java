package com.example.noviwerknemervandemaand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;

public class Tab2Activity extends AppCompatActivity {
    private GetImg_Model GetImg_Model = new GetImg_Model();
    private PermStorage_Model PermStorage_Model = new PermStorage_Model();
    private Logger logger = new Logger(2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        ImageView imgView = (ImageView) findViewById(R.id.mainImgView);;
        GetImg_Model.getTempImg(cw, imgView);

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
        this.logger.toastShow(getApplicationContext(), "Switching to Tab1");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void clickTab3(android.view.View view) {
        this.logger.switchActivity(3);
        this.logger.toastShow(getApplicationContext(), "Switching to Tab3");

        Intent intent = new Intent(this, Tab3Activity.class);
        startActivity(intent);
    }

    public void clickTab3() {
        this.logger.switchActivity(3);
        this.logger.toastShow(getApplicationContext(), "Switching to Tab3");

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
        FrameLayout img = (FrameLayout) findViewById(R.id.FrameMainImgView);
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        if ( PermStorage_Model.permSaveImg( cw, img ) ) {
            this.clickTab3();
        }
    }


}
