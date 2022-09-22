package edu.sfsu.fragmentdemo

import androidx.fragment.app.Fragment

class ExampleFragment: Fragment(R.layout.example_fragment_layout) {
    override fun onStart() {
        super.onStart()
        // Fragments have lifecycle too
    }
}