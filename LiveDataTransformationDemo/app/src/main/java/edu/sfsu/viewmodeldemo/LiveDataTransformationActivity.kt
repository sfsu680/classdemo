package edu.sfsu.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.sfsu.viewmodeldemo.databinding.LiveDataActivityMainBinding

class LiveDataTransformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LiveDataActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(TransformationViewModel::class.java)
        viewModel.combinedCount.observe(
            this,
            {
                newValue -> binding.contents.text = newValue.toString()
            }
        )


        binding.incrementOne.setOnClickListener {
            viewModel.count.value = viewModel.count.value?.plus(1)
        }

        binding.incrementTwo.setOnClickListener {
            viewModel.anotherCount.value = viewModel.anotherCount.value?.plus(1)
        }
    }
}