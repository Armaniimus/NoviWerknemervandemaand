package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class GetImg_Model {
    private Bitmap theImg = null;

    public void resolveMakeImg(ImageView img, Intent data) {
        Log.v("PermStorage_Model", "Start resolveImg()");

        Bundle extras = data.getExtras();
        this.theImg = (Bitmap) extras.get("data");
        img.setImageBitmap(this.theImg);
    }

    public void resolveLoadImg(ImageView imgView, InputStream imgInputStream) {
        Log.v("PermStorage_Model", "Start loadImg()");

        //get img from image stream
        this.theImg = BitmapFactory.decodeStream(imgInputStream);

        //bind image to the view
        imgView.setImageBitmap(this.theImg);
    }

    public boolean tempSaveImg(ContextWrapper cw) {
        Log.v("PermStorage_Model", "Start saveImg()");

        if (this.theImg == null) {
            Log.v("PermStorage_Model", "saveImg() no Image to save");
            return false;
        }

        try {
            Log.v("PermStorage_Model", "saveImg() start mainFunction");
            File directory = cw.getDir("tmpImgDir", Context.MODE_PRIVATE);
            File file = new File(directory, "img" + ".jpg");

            if (file.exists()) {
                try {
                    file.delete();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }

            if (!file.exists()) {
                Log.d("path", file.toString());
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file);
                    this.theImg.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getTempImg(ContextWrapper cw, ImageView imgView) {
        File directory = cw.getDir("tmpImgDir", Context.MODE_PRIVATE);
        File file = new File(directory, "img" + ".jpg");

        if (file.exists()) {
            Bitmap bm = BitmapFactory.decodeFile(file.toString());
            Log.v( "Tab2Activity", "bm width: "+ bm.getWidth());
            Log.v( "Tab2Activity", "bm height:"+ bm.getHeight());
            imgView.setImageBitmap(bm);
        }
    }
}
