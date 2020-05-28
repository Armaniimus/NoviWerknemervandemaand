package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.LinearLayout;
import java.io.File;

public class Tab3GridView_Model {
    private ContextWrapper cw;
    private LinearLayout Main_View;
    private android.content.Context Context;
    private Tab3SelectNHandle_Model SelectNHandle_Model = null;

    private int rowTotal;
    private RowFactory_Model[] rows = null;

    // constructor
    Tab3GridView_Model(ContextWrapper cw, LinearLayout Main_View, Context Context) {
        this.cw = cw;
        this.Main_View = Main_View;
        this.Context = Context;
    }

    public boolean run(Tab3SelectNHandle_Model obj) {
        this.SelectNHandle_Model = obj;

        File directory = cw.getDir("permImgDir", Context.MODE_PRIVATE);
        String[] imgList = directory.list();

        if (!directory.exists()) {
            return false;
        }

        this.rowTotal = (int) Math.ceil(imgList.length / 3.0);

        // create rows();
        this.rows = new RowFactory_Model[ rowTotal ];
        for (int i=0; i<rowTotal; i++) {
            this.rows[i] = new RowFactory_Model();
            this.rows[i].create( this.Context );
            this.Main_View.addView( this.rows[i].get() );
        }

        //set styling
        int imgCounter = 0;

        for (int i = 0; i<rowTotal; i++) {
            rows[i].setStyling();

            for(short ii = 0; ii<3; ii++) {
                if (imgCounter < imgList.length) {
                    File file = new File(directory, imgList[imgCounter]);
                    String uri = file.toString();

                    rows[i].setImg(ii, uri, SelectNHandle_Model);
                } else {
                    break;
                }

                imgCounter++;
            }
        }

        return true;
    }
}
