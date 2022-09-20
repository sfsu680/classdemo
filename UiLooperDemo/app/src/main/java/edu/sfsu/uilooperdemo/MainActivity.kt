package edu.sfsu.uilooperdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.calculate_button)
        button.setOnClickListener {
            triggerLongRunningOperation()
        }
    }

    //"calculates" pi
    fun triggerLongRunningOperation() {
        Thread(
            object: Runnable {
                override fun run() {
                    // Do something and report results back to UI thread
                    val msg = handler.obtainMessage();
                    // set a Bundle of data here
                    val bundle = Bundle()
                    Thread.sleep(3000)
                    bundle.putFloat("PI", 3.14f)
                    msg.setData(bundle)
                    handler.sendMessage(msg)
                }
            }
        ).start()
    }

    val handler = Handler(object: Handler.Callback{
        override fun handleMessage(msg: Message): Boolean {
            val countdownText = findViewById<TextView>(R.id.calculation_text)
            countdownText.setText("Pi = " + msg.data.getFloat("PI"))
            return true
        }
    })

}