package edu.sfsu.livedatacountdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int>
        get() = _count

    fun inc() {
        _count.value = _count.value?.inc()
    }
}