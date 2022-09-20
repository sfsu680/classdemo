package edu.sfsu.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class AnotherActivity extends AppCompatActivity {
    private static String TAG = AnotherActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Log.i(TAG, "calling onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "calling onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "calling onResume()");
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "calling onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "calling onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "calling onDestroy()");
        super.onDestroy();
    }
}