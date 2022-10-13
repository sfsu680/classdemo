package edu.sfsu.lifecycleobserverdemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class ExampleEventObserver: LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            Log.v("ExampleEventObserver", "ON_CREATE event observed")
        }
        else if (event == Lifecycle.Event.ON_DESTROY) {
            Log.v("ExampleEventObserver", "ON_DESTROY event observed")
        }
    }
}