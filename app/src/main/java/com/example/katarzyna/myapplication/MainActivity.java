package com.example.katarzyna.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.io.File;
import java.lang.String;
import java.io.IOException;
import 	java.util.Date;

import static android.app.Activity.*;
import static com.example.katarzyna.myapplication.R.id.imageView;
import static com.example.katarzyna.myapplication.R.id.info;
import static com.example.katarzyna.myapplication.R.id.photobutton;


public class MainActivity extends AppCompatActivity {
    File photoFile;
    ImageView photoView;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoView  = (ImageView) findViewById(imageView);
        Button clickButton = (Button) findViewById(photobutton);
        clickButton.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();


            }
        });
    }
    static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            int weight = imageBitmap.getWidth();
            int height = imageBitmap.getHeight();
            Log.v(Integer.toString(weight), Integer.toString(height) );
            photoView.setImageBitmap(imageBitmap);
        }
    }



    static final int REQUEST_TAKE_PHOTO = 1;




}
