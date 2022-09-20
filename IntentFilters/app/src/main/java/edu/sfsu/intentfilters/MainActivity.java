package edu.sfsu.intentfilters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, ExplicitActivity.class);
                startActivity(intent);


            }
        });

        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri mapUri = Uri.parse("https://www.google.com/maps/place/Google+Building+40,+1600+Amphitheatre+Pkwy,+Mountain+View,+CA+94043");
                Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
                startActivity(intent);
            }
        });

    }
}