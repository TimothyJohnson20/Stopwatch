package com.example.stopwatch;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
public class MainActivity extends AppCompatActivity {
    private Button startStop;
    private Button reset;
    private Chronometer stopWatch;
    private boolean isOn;
    private long lastNumber;
    private ConstraintLayout constraintLayout;
    public static final String KEY_CHRONOMETER_BASE = "chronometer base";
    public static final String KEY_CHRONOMETER_STOPPED = "chronometer stopped";

    private void wireWidgets() {
        startStop = findViewById(R.id.button_main_start_stop);
        reset = findViewById(R.id.button_main_reset);
        stopWatch = findViewById(R.id.chronometer_main_time);
        constraintLayout = findViewById(R.id.constraint_mian);
    }
    private void setListeners() {

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopWatch.setBase(SystemClock.elapsedRealtime());
                lastNumber = SystemClock.elapsedRealtime();
            }

        });
        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isOn) {
                    isOn = true;
                    startStop.setText(getString(R.string.main_stop));
                    stopWatch.start();
                    stopWatch.setBase(stopWatch.getBase() + (SystemClock.elapsedRealtime() - lastNumber));
                }
                else{
                    isOn = false;
                    startStop.setText(R.string.main_start);
                    stopWatch.stop();
                    lastNumber = SystemClock.elapsedRealtime();
                }
            }
        });
    }
    public static final String TAG = MainActivity.class.getSimpleName();
    //  Look up the Log class for Android
    //  List all the levels of logging and when they're used

    //  Verbose - Debug - Info - Warning - Error - Assert
    //  When app is launched - OnCreate, onStart, onResume
    //  When app is closed - onPause, onStop
    //  When app is opened again - onStart, onResume
    //  When app is destroyed - onStop, onDestroy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        isOn = false;
        wireWidgets();
        setListeners();
        //region backgroundcolor
        lastNumber = SystemClock.elapsedRealtime();
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int bl = (int)(Math.random() * 256);
        int color = Color.rgb(r, g, bl);
        constraintLayout.setBackgroundColor(color);
        //endregion

        //  if the savedInstanceState isn't null
        //  pull out the value of the base that we saved from the bundle
        //  set the chronometer's base to that value
        //  start the chronometer

        //  next functionality would be to also store in the bundle whether it was running or stopped
        //  to decide to start it or not in onCreate
        if(savedInstanceState != null){
            stopWatch.setBase(savedInstanceState.getLong(KEY_CHRONOMETER_BASE));
            isOn = savedInstanceState.getBoolean(KEY_CHRONOMETER_STOPPED);
            if (!isOn){
                stopWatch.stop();
                startStop.setText(getString(R.string.main_start));

            }
            else{
                stopWatch.start();
                startStop.setText(R.string.main_stop);
                lastNumber = SystemClock.elapsedRealtime();

            }
        }
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


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_CHRONOMETER_BASE, stopWatch.getBase());
        outState.putBoolean(KEY_CHRONOMETER_STOPPED, isOn);

    }
}