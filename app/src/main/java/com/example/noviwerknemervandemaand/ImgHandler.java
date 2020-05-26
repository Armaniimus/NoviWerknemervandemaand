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

public class ImgHandler {
    private Bitmap theImg = null;

    public void resolveMakeImg(ImageView img, Intent data) {
        Log.v("ImgHandler", "Start resolveImg()");

        Bundle extras = data.getExtras();
        this.theImg = (Bitmap) extras.get("data");
        img.setImageBitmap(this.theImg);
    }

    public void resolveLoadImg(ImageView imgView, InputStream imgInputStream) {
        Log.v("ImgHandler", "Start loadImg()");

        //get img from image stream
        this.theImg = BitmapFactory.decodeStream(imgInputStream);

        //bind image to the view
        imgView.setImageBitmap(this.theImg);
    }

    public boolean tempSaveImg(ContextWrapper cw) {
        Log.v("ImgHandler", "Start saveImg()");

        if (this.theImg == null) {
            Log.v("ImgHandler", "saveImg() no Image to save");
            return false;
        }

        try {
            Log.v("ImgHandler", "saveImg() start mainFunction");
            File directory = cw.getDir("tmpImgDir", Context.MODE_PRIVATE);
            File file = new File(directory, "img" + ".jpg");

            if (file.exists()) {
                try {
                    file.delete();
                } catch(Exception Error1) {

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
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        } catch (Exception Error2) {

        }
        return false;
    }

    public boolean permSaveImg(ContextWrapper cw) {
        Log.v("ImgHandler", "Start permSaveImg()");

        if (this.theImg == null) {
            Log.v("ImgHandler", "permSaveImg() no Image to save");
            return false;
        }

        try {
            Log.v("ImgHandler", "permSaveImg() start mainFunction");
            File directory = cw.getDir("permImgDir", Context.MODE_PRIVATE);
            File file = new File(directory, "img" + ".jpg");

            if (!file.exists()) {
                Log.d("path", file.toString());
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(file);
                    this.theImg.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                    fos.flush();
                    fos.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        } catch (Exception Error2) {

        }
        return false;
    }

    public void Set_theImg( Bitmap img ) {
        Log.v("ImgHandler", "Start Set_theImg()");
        this.theImg = img;
    }
}
