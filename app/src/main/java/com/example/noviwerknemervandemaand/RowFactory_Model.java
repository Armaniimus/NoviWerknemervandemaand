package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.TableRow;

public class RowFactory_Model {
    private RowImgFactory_Model[] images = new RowImgFactory_Model[3];
    private TableRow row = null;

    public void create( Context Context ) {
        this.row = new TableRow( Context );
        for (short i=0; i<3; i++) {
            images[i] = new RowImgFactory_Model();
            images[i].create( Context );
            this.row.addView( images[i].get() );
        }
    }

    public TableRow get() {
        return this.row;
    }

    public void setStyling() {
        ViewGroup.LayoutParams layoutParams = this.row.getLayoutParams();
        layoutParams.width = layoutParams.MATCH_PARENT;
        layoutParams.height = layoutParams.WRAP_CONTENT;
        this.row.setLayoutParams(layoutParams);

        for (short i=0; i<3; i++) {
            this.images[i].setStyling();
        }
    }

    public void setImg(short index, String uri, Tab3SelectNHandle_Model SelectNHandle_Model) {
        this.images[index].setActiveImg(uri, SelectNHandle_Model);
    }
}