package edu.sfsu.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val titleView = findViewById<TextView>(R.id.title)
        val anotherTitleView = findViewById<TextView>(R.id.anotherTitle)
        val incrementOne = findViewById<Button>(R.id.incrementOne)
        val incrementTwo = findViewById<Button>(R.id.incrementTwo)
        val incrementThree = findViewById<Button>(R.id.incrementThree)
        val submitCountModel = ViewModelProvider(this).get(SubmitCountModel::class.java)

        submitCountModel.count.observe(
            this,
            Observer {
                    titleView.text = "The count: $it"
                anotherTitleView.text = "Another count: $it"
            }
        )

        incrementOne.setOnClickListener {
            submitCountModel.increment(1)
        }

        incrementTwo.setOnClickListener {
            submitCountModel.increment(2)
        }

        incrementThree.setOnClickListener {
            submitCountModel.increment(3)
        }
    }
}