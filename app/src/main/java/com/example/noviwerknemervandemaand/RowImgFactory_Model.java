package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RowImgFactory_Model {
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
        this.img.setPadding(10,10,10,10);
    }

    public void setImg(Bitmap bm) {
        this.img.setImageBitmap(bm);
    }
}