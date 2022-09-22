package edu.sfsu.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment_container_1, MyFragment() )
        }


    }
}

/*
supportFragmentManager.commit {
            setReorderingAllowed(true)
            val fragment = ExampleFragment()
            add(R.id.fragment_container_1, fragment)
            addToBackStack(null)
        }

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            val fragment = ExampleFragment()
            add(R.id.fragment_container_2, fragment)
            addToBackStack(null)
        }
 */