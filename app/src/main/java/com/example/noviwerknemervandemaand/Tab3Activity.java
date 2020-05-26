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
    Logger logger = new Logger(3);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        this.readLogList();
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


    private int readLogList( ) {
        Log.v("Tab3Activity", "start readLogList()");
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        File directory = cw.getDir("permImgDir", Context.MODE_PRIVATE);

        if (!directory.exists()) {
            return 0;
        }

        LinearLayout Main_view =  (LinearLayout) findViewById(R.id.Main_view);
        String[] imgList = directory.list();
        int rowTotal = (int) Math.ceil(imgList.length / 3.0) ;
        Log.v("ello","total rows = " + rowTotal);

        ArrayList<TableRow> rows = new ArrayList<>();
        ArrayList<ImageView> rowImgItems = new ArrayList<>();

        // create rows();
        for (int i=0; i<rowTotal; i++) {
            rows.add( new TableRow(this) );
        }

        // create img Items();
        for (int i = 0; i<imgList.length; i++) {
            rowImgItems.add(new ImageView(this));
        }

        // add img items to rows
        int itemCurrent = 0;
        int rItemTotal = rowImgItems.size();

        for (int rNr=0; rNr<rowTotal; rNr++) {
            for(int rItemNr = 0; rItemNr<3; rItemNr++) {
                if (itemCurrent >= rItemTotal) {
                    break;
                } else {
                    rows.get(rNr).addView( rowImgItems.get(itemCurrent) );
                }

                itemCurrent++;
            }



//            if (rItemNr >= 2) {
//                rItemNr = 0;
//                rNr++;
//            } else {
//                rItemNr++;
//            }
        }

        //add rows to view()
        for (int i=0; i<rowTotal; i++) {
            Main_view.addView( rows.get(i) );
        }

        //Add styling to Img items
        for (int i = 0; i<imgList.length; i++) {
            File file = new File(directory, imgList[i]);
            Bitmap bm = BitmapFactory.decodeFile(file.toString());
            rowImgItems.get(i).setImageBitmap(bm);

            rowImgItems.get(i).setAdjustViewBounds(true);

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rowImgItems.get(i).getLayoutParams();
            layoutParams.width = layoutParams.MATCH_PARENT;
            layoutParams.height = layoutParams.WRAP_CONTENT;
            layoutParams.weight =  1f;
            rowImgItems.get(i).setLayoutParams(layoutParams);
            rowImgItems.get(i).setPadding(10,10,10,10);

            Log.e( "scaleType", ""+ rowImgItems.get(i).getScaleType() );
        }

        //add styling to rows
        for (int i=0; i<rowTotal; i++) {
            ViewGroup.LayoutParams layoutParams = rows.get(i).getLayoutParams();
            layoutParams.width = layoutParams.MATCH_PARENT;
            layoutParams.height = layoutParams.WRAP_CONTENT;
            rows.get(i).setLayoutParams(layoutParams);
        }

        return 1;
    }
}
