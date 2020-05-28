package com.example.noviwerknemervandemaand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private static final int MAKE_IMAGE = 1;
    private static final int LOAD_IMAGE = 2;

    private Logger logger = new Logger(1);
//    private PermStorage_Model PermStorage_Model = new PermStorage_Model();
    private GetImg_Model GetImg_Model = new GetImg_Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickTab2(android.view.View view) {
        this.logger.switchActivity(2);
        this.logger.toastShow(getApplicationContext(), "Switching to Tab2");

        Intent intent = new Intent(this, Tab2Activity.class);
        startActivity(intent);
    }

    public void clickTab2() {
        this.logger.switchActivity(2);
        this.logger.toastShow(getApplicationContext(), "Switching to Tab2");

        Intent intent = new Intent(this, Tab2Activity.class);
        startActivity(intent);
    }

    public void clickTab3(android.view.View view) {
        this.logger.switchActivity(3);
        this.logger.toastShow(getApplicationContext(), "Switching to Tab3");

        Intent intent = new Intent(this, Tab3Activity.class);
        startActivity(intent);
    }

    public void makeImg(android.view.View view) {
        Log.v("MainActivity", "start makeImg()");
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, MAKE_IMAGE);
        }
    }

    public void loadImg(android.view.View view) {
        Log.v("MainActivity", "start loadImg()");

        // Where do we set the data
        File picDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        // get uri
        Uri data = Uri.parse( picDir.getPath() );

        // set Intent with data and type
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setDataAndType(data,"image/*");

        // Launching the Intent
        startActivityForResult(photoPickerIntent, LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.v("MainActivity", "start onActivityResult()");
        ImageView imgView = (ImageView) findViewById(R.id.mainImgView);

        if (resultCode != RESULT_OK) {
            Log.w("MainActivity", "OnActivityResult failed Result != OK");
            return;
        }

        if (requestCode == MAKE_IMAGE) {
            Log.w("MainActivity", "OnActivityResult start resolving makeImg()");
            GetImg_Model.resolveMakeImg(imgView, data);
            return;

        }  else if (requestCode == LOAD_IMAGE) {
            Log.w("MainActivity", "OnActivityResult start resolving loadImg()");
            try {
                InputStream imgInputStream = getContentResolver().openInputStream(data.getData());
                GetImg_Model.resolveLoadImg(imgView, imgInputStream);
            } catch(FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "unable to open image", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void saveImg(android.view.View view) {
        Log.v("MainActivity", "start saveImg()");

        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        if ( GetImg_Model.tempSaveImg(cw) ) {
            this.clickTab2();
        }
    }
}
