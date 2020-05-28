package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Tab3SelectNHandle_Model {
    private View currentView = null;

    public void select(View view) {
        View oldView = this.currentView;
        this.currentView = view;

        if (oldView != null) {
            oldView.setBackgroundResource(0);

            Log.v("oldView", oldView.toString());
            Log.v("newView", view.toString());
        }

        this.currentView.setBackgroundResource(R.drawable.selected_border);
    }

    public String getImgUri() {
        Log.v( "Tab3SelectNHandle_Model", "start getImgUri()" );
        if (this.currentView == null) {
            return null;
        }

        String uri = this.currentView.getTag().toString();
        if (uri == null) {
            Log.v("Tab3SelectNHandle_Model", "ImgPath == null");
            return null;
        }

        return uri;
    }

    public View getView() {
        Log.v( "Tab3SelectNHandle_Model", "start getBitMap()" );
        if (this.currentView == null) {
            return null;
        }

        return this.currentView;
    }

    public Bitmap getBitmap() {
        Log.v( "Tab3SelectNHandle_Model", "start getBitMap()" );
        if (this.currentView == null) {
            return null;
        }
        ImageView img = (ImageView) this.currentView;
        Bitmap bm = ((BitmapDrawable) img.getDrawable()).getBitmap();

        return bm;
    }
}
