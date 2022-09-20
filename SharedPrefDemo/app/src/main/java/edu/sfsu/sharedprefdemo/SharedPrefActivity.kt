package edu.sfsu.sharedprefdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import edu.sfsu.sharedprefdemo.databinding.ActivityMainBinding

class SharedPrefActivity : AppCompatActivity() {
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
            Toast.makeText(this, "read name from shared preferences", Toast.LENGTH_LONG).show()
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
        // get shared preference in private mode
        val sharedPref: SharedPreferences = getSharedPreferences("name preference", MODE_PRIVATE)
        // return looked up value or default
        return sharedPref.getString("user_name", null)
    }

    fun saveName(name: String) {
        // get shared preference in private mode
        val sharedPref: SharedPreferences = getSharedPreferences("name preference", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        // save value
        editor.putString("user_name", name)
        // always remember to commit
        editor.commit()
    }
}