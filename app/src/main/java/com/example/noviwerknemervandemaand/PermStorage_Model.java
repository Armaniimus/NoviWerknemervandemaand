package com.example.noviwerknemervandemaand;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileOutputStream;

public class PermStorage_Model {

    public boolean permSaveImg(ContextWrapper cw, FrameLayout img) {
        // init Variables
        Log.v("Tabs2Activity", "start clickStoreImg" );

        Bitmap bm = null;

        FileOutputStream fos = null;

        try {
            img.setDrawingCacheEnabled(true);
            img.buildDrawingCache();
            bm = img.getDrawingCache();
        } catch (Exception E) {
            Log.e("BitmapError", "" + E);
            return false;
        }

        try {
            // create path name
            Long tsLong = System.currentTimeMillis()/1000;
            String ts = tsLong.toString();
            File directory = cw.getDir("permImgDir", Context.MODE_PRIVATE);

            // create file object
            File f = new File(directory, "img_" + ts + ".jpg");
            Log.d("filepath", f.toString());

            //try to write file
            try {
                fos = new FileOutputStream(f);
                bm.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();

                Log.d("FileSuccess", "File has been written succesfully");
            } catch (Exception e) {
                Log.e("FilewriteError", "" + e);
                return false;
            }


        } catch (Exception E) {
            Log.e("BitmapError", "" + E);
            return false;
        }

        return true;
    }
}
