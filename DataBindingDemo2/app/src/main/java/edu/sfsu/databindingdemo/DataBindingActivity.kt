package edu.sfsu.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import edu.sfsu.databindingdemo.databinding.DemoActivityMainBinding

class DataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: DemoActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.demo_activity_main)
        binding.counterViewModel = CounterViewModel()
        binding.lifecycleOwner = this // important to set life cycle owner
    }
}