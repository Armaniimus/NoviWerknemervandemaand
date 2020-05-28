package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.LinearLayout;
import java.io.File;

public class Tab3GridView_Model {
    private ContextWrapper cw;
    private LinearLayout Main_View;
    private android.content.Context Context;

    private int rowTotal;
    private RowFactory_Model[] rows = null;

    // constructor
    Tab3GridView_Model(ContextWrapper cw, LinearLayout Main_View, Context Context) {
        this.cw = cw;
        this.Main_View = Main_View;
        this.Context = Context;
    }

    public boolean run() {
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
        Tab3SelectNHandle_Model SelectNHandle_Model = new Tab3SelectNHandle_Model();
        int imgCounter = 0;

        for (int i = 0; i<rowTotal; i++) {
            rows[i].setStyling();

            for(short ii = 0; ii<3; ii++) {
                if (imgCounter < imgList.length) {
                    File file = new File(directory, imgList[imgCounter]);
                    Bitmap bm = BitmapFactory.decodeFile(file.toString());

                    rows[i].setImg(ii, bm, SelectNHandle_Model);
                } else {
                    break;
                }

                imgCounter++;
            }
        }

        return true;
    }
}
