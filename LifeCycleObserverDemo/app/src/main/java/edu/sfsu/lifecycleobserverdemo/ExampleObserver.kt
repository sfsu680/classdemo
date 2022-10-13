package edu.sfsu.lifecycleobserverdemo

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class ExampleObserver: DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.v("ExampleObserver", "onCreate observed")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.v("ExampleObserver", "onDestroy observed")
    }
}