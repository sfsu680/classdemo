package edu.sfsu.asyncdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView countdownText = findViewById(R.id.countdown_text);
        Button button = findViewById(R.id.countdown_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.execute(new CountdownRunnable(countdownText));
            }
        });
    }

    public static class CountdownRunnable implements Runnable {
        final private TextView countdownText;
        CountdownRunnable(TextView countdownText) {
            this.countdownText = countdownText;
        }

        @Override
        public void run() {
            try {
                for(int count = 10; count >= 0; count--){
                    final int countdown = count;
                    countdownText.post(
                            new Runnable() {
                                @Override
                                public void run() {
                                    countdownText.setText(countdown + "!");
                                }
                            }
                    );
                    Thread.sleep(1000);
                }


            }
            catch (InterruptedException exception) {
                Log.e("MainActivity", "interrupted", exception);
            }
        }
    }
}