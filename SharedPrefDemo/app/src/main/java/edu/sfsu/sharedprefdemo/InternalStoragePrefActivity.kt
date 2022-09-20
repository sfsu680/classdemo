package edu.sfsu.sharedprefdemo

import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.sfsu.sharedprefdemo.databinding.ActivityMainBinding
import java.io.*

class InternalStoragePrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userName: String? = getName()

        if (userName != null) {
            binding.name.setText("Hello " + userName)
            binding.name.visibility = View.VISIBLE
            binding.enterName.visibility = View.GONE
            binding.submit.visibility = View.GONE
            Toast.makeText(this, "read name from internal storage", Toast.LENGTH_LONG).show()
        }
        else {
            binding.submit.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        saveName(binding.enterName.getText().toString())

                        binding.name.setText("Hello " + binding.enterName.getText())
                        binding.name.visibility = View.VISIBLE
                        binding.enterName.visibility = View.GONE
                        binding.submit.visibility = View.GONE
                    }
                }
            )
        }
    }

    fun getName(): String? {
        try {
            val input: FileInputStream = openFileInput("username.text")

            val reader: InputStreamReader = input.reader()
            val bufferedReader = BufferedReader(reader)
            val name = bufferedReader.readLine()
            return if (name.isNotEmpty()) name else null
        }
        catch (e: Exception) {
            return null
        }
    }

    fun saveName(name: String) {
        val output: FileOutputStream = openFileOutput("username.text", MODE_PRIVATE)
        output.write(name.toByteArray())
        output.flush()
        output.close()
    }
}