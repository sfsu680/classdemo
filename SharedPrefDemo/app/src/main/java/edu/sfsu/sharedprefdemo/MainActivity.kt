package edu.sfsu.sharedprefdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.sfsu.sharedprefdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submit.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    binding.name.setText("Hello " + binding.enterName.text)
                    binding.name.visibility = View.VISIBLE
                    binding.enterName.visibility = View.GONE
                    binding.submit.visibility = View.GONE
                }
            }
        )
    }


}