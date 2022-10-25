package edu.sfsu.viewmodeldemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubmitCountModel: ViewModel() {
    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int>
        get() = _count

    fun increment(amount: Int) {
        _count.value = _count.value?.plus(amount)
    }
}