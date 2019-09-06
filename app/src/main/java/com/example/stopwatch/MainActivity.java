package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Button startStop;
    private Button reset;
    private Chronometer stopWatch;

    private void wireWidgets() {
        startStop = findViewById(R.id.button_main_start_stop);
        reset = findViewById(R.id.button_main_reset);
        stopWatch = findViewById(R.id.chronometer_main_time);
    }
    private void setListeners() {
        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopWatch.start();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    public static final String TAG = MainActivity.class.getSimpleName();

    //  Look up the Log class for Android
    //  List all the levels of logging and when they're used
    //  Verbose - Debug - Info - Warning - Error - Assert

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

    }


}
