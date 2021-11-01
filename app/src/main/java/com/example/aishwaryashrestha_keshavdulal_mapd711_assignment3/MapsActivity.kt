package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aishwaryashrestha_keshavdulal_mapd711_assignment3.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private var selectedCity: LatLng = LatLng(-34.0, 151.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val intent = intent
        // Extract values from intent object using relevant keys
        println(">>>" + intent.getStringExtra("cityIndex"))
        val cityIndex = intent.getStringExtra("cityIndex")?.toInt() ?: 1

        when (cityIndex) {
            1 -> {
                selectedCity = LatLng(-34.0, 151.0)
            }
            2 -> {
                selectedCity = LatLng(43.6532, 79.3832)
            }
            3 -> {
                selectedCity = LatLng(49.2827, 123.1207)
            }
            4 -> {
                selectedCity = LatLng(46.8139, 71.2080)
            }
            5 -> {
                selectedCity = LatLng(45.4215, 75.6972)
            }

        }
        Toast.makeText(this@MapsActivity, cityIndex.toString(), Toast.LENGTH_SHORT).show()
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in to selected city and move the camera
        mMap.addMarker(MarkerOptions().position(selectedCity).title("Marker in City"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(selectedCity))
    }
}
