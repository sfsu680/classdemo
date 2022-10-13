package edu.sfsu.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleView = findViewById<TextView>(R.id.title)
        val submitButton = findViewById<Button>(R.id.submit)
        val submitCountModel = ViewModelProvider(this).get(SubmitCountModel::class.java)
        titleView.text = "Submitted: ${submitCountModel.count} times"

        submitButton.setOnClickListener {
            submitCountModel.count++
            titleView.text = "Submitted: ${submitCountModel.count} times"
        }
    }
}