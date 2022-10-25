package edu.sfsu.livedatacountdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val timerView = findViewById<TextView>(R.id.timer)
        val counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)
        counterViewModel.count.observe(
            this,
            Observer {
                timerView.text = "$it"
                Log.d("MainActivity", "Updating timerView")
            }
        )

        val handler = Handler(this.mainLooper)
        val runnable = object: Runnable{
            override fun run() {
                Log.d("MainActivity", "Updating counter")
                counterViewModel.inc()
                handler.postDelayed(this, 1000)
            }
        }

        handler.post(runnable)
    }
}