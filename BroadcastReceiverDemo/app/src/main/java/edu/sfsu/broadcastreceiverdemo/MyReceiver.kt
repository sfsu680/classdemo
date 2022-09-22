package edu.sfsu.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val isAirplayMode = intent.getBooleanExtra("state", false)
        if (isAirplayMode) {
            Toast.makeText(context, "Airplay mode on", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Airplay mode off", Toast.LENGTH_LONG).show()
        }
    }
}