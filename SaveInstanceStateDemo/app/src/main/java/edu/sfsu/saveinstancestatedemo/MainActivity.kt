package edu.sfsu.saveinstancestatedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var submitCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleView = findViewById<TextView>(R.id.title)
        titleView.text = "Submitted: $submitCount times"

        val submitButton = findViewById<Button>(R.id.submit)
        submitButton.setOnClickListener {
            submitCount++
            titleView.text = "Submitted: $submitCount times"
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        submitCount = savedInstanceState.getInt("submit-count")
        val titleView = findViewById<TextView>(R.id.title)
        titleView.text = "Submitted: $submitCount times"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("submit-count", submitCount)

        // must call super
        super.onSaveInstanceState(outState)
    }
}