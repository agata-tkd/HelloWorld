package com.example.agata.helloworld;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import org.opencv.core.Mat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar);
        int p = bar.getProgress();
        if (p < 5) {
            p++;
            bar.setProgress(p);
        } else if (p == 5){
            Button but = (Button) findViewById(R.id.button);
            but.setText("@string/endClick");
        }
        Mat a = new Mat();
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    public void onCamClick(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}
