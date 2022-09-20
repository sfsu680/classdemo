package edu.sfsu.lifecycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifecycleDemoActivity extends AppCompatActivity {
    private static String TAG = LifecycleDemoActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_demo);
        Button button = findViewById(R.id.start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LifecycleDemoActivity.this, AnotherActivity.class);
                startActivity(intent);
            }
        });

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