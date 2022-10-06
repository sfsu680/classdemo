package edu.sfsu.nfcdemo

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NfcAdapter
import android.nfc.NfcManager
import android.nfc.tech.Ndef
import android.nfc.tech.NfcA
import android.nfc.tech.NfcB
import android.nfc.tech.NfcF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nfcView: TextView
    lateinit var adapter: NfcAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nfcView = findViewById(R.id.nfc)

        initializeNfc()

//        readNfcIntent(this.getIntent()) //if app launched from Nfc reading

    }

    override fun onResume() {
        super.onResume()
        try {
            val intent = Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            val nfcPendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
            val techList = arrayOf<String>(NfcA::class.java.name, NfcB::class.java.name, NfcF::class.java.name, Ndef::class.java.name)
//            adapter.enableForegroundDispatch(this, nfcPendingIntent, null, arrayOf(techList))
            adapter.enableForegroundDispatch(this, nfcPendingIntent, null, null)
        } catch (exception: IllegalStateException) {
            Log.e("MainActivity", "Error enabling NFC foreground dispatch", exception)
        }
    }


    override fun onPause() {
        adapter.disableForegroundDispatch(this)
        super.onPause()
    }

    override fun onNewIntent(intent: Intent?) {
        readNfcIntent(intent)
        super.onNewIntent(intent)
    }

    fun initializeNfc() {
        val nfcManager = getSystemService(Context.NFC_SERVICE) as NfcManager
        adapter = nfcManager.defaultAdapter
    }

    fun readNfcIntent(nfcIntent: Intent?) {
        val action = nfcIntent?.action
        if (NfcAdapter.ACTION_NDEF_DISCOVERED == action ||
                NfcAdapter.ACTION_TAG_DISCOVERED == action) {
            val rawMsgs = nfcIntent?.getByteArrayExtra(NfcAdapter.EXTRA_ID)
            val stringBuilder = StringBuilder()
            rawMsgs?.map {
                stringBuilder.append(it.toInt())
                stringBuilder.append("\n")
            }
            nfcView.text = stringBuilder.toString()
        }
    }

}