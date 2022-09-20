package edu.sfsu.dangerouspermissiondemo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class MainActivity : AppCompatActivity() {
    lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        val gpsCoordinates = findViewById<TextView>(R.id.gps_coordinates)


        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED ) {
            fusedLocationClient.lastLocation.addOnSuccessListener {
                gpsCoordinates.setText("long: ${it?.longitude}, lat: ${it?.latitude}")
            }
        }
        else {
            // You can directly ask for the permission.
            // The registered ActivityResultCallback gets the result of this request.
            val permissions = arrayOf<String>(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            requestPermissions(permissions, 1234)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1234) {
            val gpsCoordinates = findViewById<TextView>(R.id.gps_coordinates)
            fusedLocationClient.lastLocation.addOnSuccessListener {
                gpsCoordinates.setText("long: ${it?.longitude}, lat: ${it?.latitude}")
            }
        }

    }
}