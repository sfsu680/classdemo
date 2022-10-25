package edu.sfsu.databindingdemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    val count = MutableLiveData<Int>(0)
    fun increment() {
        count.value = count.value?.inc()
    }
}