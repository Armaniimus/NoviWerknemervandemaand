package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RowImgFactory_Model {
    private Tab3SelectNHandle_Model SelectNHandle_Model = null;
    private ImageView img;
    RowImgFactory_Model() {

    }

    public void create( Context Context) {
        this.img = new ImageView(Context);
    }

    public ImageView get() {
        return this.img;
    }

    public void setStyling() {
        this.img.setAdjustViewBounds(true);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.img.getLayoutParams();
        layoutParams.width = layoutParams.MATCH_PARENT;
        layoutParams.height = layoutParams.WRAP_CONTENT;
        layoutParams.weight =  1f;
        this.img.setLayoutParams(layoutParams);
    }

    public void setActiveImg(Bitmap bm, Tab3SelectNHandle_Model SelectNHandle_Model) {
        this.img.setImageBitmap(bm);
        this.img.setPadding(10,10,10,10);
        this.img.setClickable(true);
        this.img.setFocusable(true);
        this.SelectNHandle_Model = SelectNHandle_Model;
        this.img.setOnClickListener(v -> this.SelectNHandle_Model.select(v));
    }
}