package edu.sfsu.viewmodeldemo

import androidx.lifecycle.*

class TransformationViewModel: ViewModel() {
    val count = MutableLiveData<Int>(0)
    val anotherCount = MutableLiveData<Int>(0)

    val countText: LiveData<String> = Transformations.map<Int, String>(
        count,
        {
            number -> "The count is $number"
        }
    )

    val floatingPointCount: LiveData<Float> = Transformations.switchMap<Int, Float>(
        count,
        {
            number -> FloatLiveData(number.toFloat())
        }
    )

    val combinedCount = MediatorLiveData<Int>()

    init {
        combinedCount.addSource(
            count,
            {
                newValue -> combinedCount.value = maxOf(newValue, combinedCount.value ?: 0)
            }
        )
        combinedCount.addSource(
            anotherCount,
            {
               newValue -> combinedCount.value = maxOf(newValue, combinedCount.value ?: 0)
            }
        )
    }
}

class FloatLiveData(initialValue: Float): LiveData<Float>(initialValue)