package edu.sfsu.broadcastreceiverdemo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var receiver: MyReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiver = MyReceiver()

        val intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        this.registerReceiver(receiver, intentFilter)
    }

    override fun onStop() {
        // remember to unregister broadcast receiver when stopping
        unregisterReceiver(receiver)
        super.onStop()
    }
}