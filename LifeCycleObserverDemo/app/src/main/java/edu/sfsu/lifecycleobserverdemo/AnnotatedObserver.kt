package edu.sfsu.lifecycleobserverdemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class AnnotatedObserver: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        Log.v("AnnotatedObserver", "onCreate also observed")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        Log.v("AnnotatedObserver", "onDestroy also observed")
    }
}