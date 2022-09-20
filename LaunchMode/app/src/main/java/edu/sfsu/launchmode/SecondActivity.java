package edu.sfsu.launchmode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast toast = Toast.makeText(this, "onCreate called", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast toast = Toast.makeText(this, "onNewIntent called", Toast.LENGTH_SHORT);
        toast.show();
    }





    @Override
    String getName() {
        return "Second";
    }

    @Override
    Activity getThisActivity() {
        return this;
    }
}