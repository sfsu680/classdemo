package edu.sfsu.dialogfragmentdemo

import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class ExampleDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = AlertDialog.Builder(requireContext())
            .setMessage("How are you today?")
            .setPositiveButton("Good") {
                    _,_ ->  Toast.makeText(requireContext(), "Good to hear", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Bad") {
                    _,_ -> Toast.makeText(requireContext(), "Aww too bad", Toast.LENGTH_LONG).show()
            }
            .create()
        return dialog
    }
}