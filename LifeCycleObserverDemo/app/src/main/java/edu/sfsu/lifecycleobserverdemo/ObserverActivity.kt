package edu.sfsu.lifecycleobserverdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class ObserverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("MainActivity", "onCreate called")
        lifecycle.addObserver(ExampleEventObserver())
    }

    override fun onDestroy() {
        Log.v("MainActivity", "onDestroy called")
        super.onDestroy()
    }
}