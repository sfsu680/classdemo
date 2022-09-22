package edu.sfsu.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class AirplayModeChangeBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)

        if (isAirplaneModeEnabled) {
            val toast = Toast.makeText(context, "Airplane Mode enabled", Toast.LENGTH_LONG)
            toast.show()
        } else {
            val toast = Toast.makeText(context, "Airplane Mode disabled", Toast.LENGTH_LONG)
            toast.show()
        }
    }
}