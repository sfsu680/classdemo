package edu.sfsu.httperrordemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.sfsu.httperrordemo.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(getLayoutInflater())
        val view = binding.root
        setContentView(view)


        // this will fail because we're trying to make a network request from main thread
//            val catFactsUrl = URL("https://catfact.ninja/fact")
//            try {
//                val reader = BufferedReader(InputStreamReader(catFactsUrl.openStream()))
//                val fact = reader.readLine()
//                binding.catFact.post {
//                    binding.catFact.text = fact
//                }
//            } catch (e: IOException) {
//                Log.w("MainActivity", e)
//            }



//        thread {
//            val catFactsUrl = URL("https://catfact.ninja/fact")
//            try {
//                val reader = BufferedReader(InputStreamReader(catFactsUrl.openStream()))
//                val fact = reader.readLine()
//                binding.catFact.post {
//                    binding.catFact.text = fact
//                }
//            } catch (e: IOException) {
//                Log.w("MainActivity", e)
//            }
//        }
    }
}