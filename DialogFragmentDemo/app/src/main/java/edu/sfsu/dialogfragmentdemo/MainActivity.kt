package edu.sfsu.dialogfragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.tap_me)
        button.setOnClickListener {
            ExampleDialogFragment().show(supportFragmentManager, "tag_name")
        }
    }
}