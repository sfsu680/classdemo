package edu.sfsu.looperdemo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countdownText = findViewById<TextView>(R.id.delayed_text)
        val button = findViewById<Button>(R.id.delayed_button)

        val myThread = MyThread()
        myThread.start()

        button.setOnClickListener {

            myThread.handler?.post {
                Thread.sleep(10000)
                countdownText.post { countdownText.text = "delayed action" }
            }

        }
    }

    class MyThread : Thread() {
        var handler: Handler? = null
        override fun run() {
            // Prepare a looper for the current thread
            // The current thread is determined implicitly

            Looper.prepare()

            // Create a new message handler. The new handler
            // will automatically be associated with the looper
            // of the current thread

            handler = Handler(Looper.getMainLooper()) //not deprecated

            // Calling Looper.loop() will enter the dispatch
            // loop of the looper. loop() will not return
            // unless the looper is quit via Looper.quit()

            Looper.loop()
        }
    }


}