package edu.sfsu.asynctaskdemo

import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.download_button)
        button.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    DownLoadTask().execute(URL("https://some-domain.com"))
                }
            }
        )
    }

     inner class DownLoadTask() : AsyncTask<URL, Any, Long>() {
         override fun doInBackground(vararg params: URL?): Long {
             // ...download file with the URL, return the number of bytes as Long
             Thread.sleep(3000)
             return 1024
         }

        override fun onPostExecute(size: Long) {
            //println(“Downloaded: $size”)
            val downloadText = findViewById<TextView>(R.id.download_result)
            downloadText.setText("Downloaded: $size")
        }
    }
}