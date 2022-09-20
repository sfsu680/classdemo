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

class ExternalStoragePrefActivity : AppCompatActivity() {
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
            Toast.makeText(this, "read name from external storage", Toast.LENGTH_LONG).show()
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
        val externalFile: File = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "username.txt")
        Log.d("SharedPref", "Reading from $externalFile")
        if (!externalFile.exists()) {
            return null
        }
        val reader = BufferedReader(FileReader(externalFile))
        val currentLine: String = reader.readLine()
        reader.close()
        return if (currentLine.isNotEmpty()) currentLine else null
    }

    fun saveName(name: String) {
        val externalFile: File = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "username.txt")
        Log.d("SharedPref", "Writing to $externalFile")
        val out = FileOutputStream(externalFile)
        out.write(name.toByteArray())
        out.close()
    }
}