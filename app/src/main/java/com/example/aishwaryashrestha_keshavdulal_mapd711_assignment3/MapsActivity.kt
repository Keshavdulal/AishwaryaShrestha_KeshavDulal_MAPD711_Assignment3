package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment3

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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

        var cruise1: LatLng = LatLng(43.7184038, -79.5181405)
        var cruise2: LatLng = LatLng(43.6114038, -79.4181405)
        var cruise3: LatLng = LatLng(43.8114038, -79.481405)
        var cruise4: LatLng = LatLng(43.4114038, -79.3181405)
        var cruise5: LatLng = LatLng(43.5114038, -79.5581405)
        val zoomLevel = 11f

        // Add a marker in to selected city and move the camera
        mMap.addMarker(
            MarkerOptions().position(cruise1)
                .title("Toronto Cruises 1")
                .snippet("+12345678, 21 St.Johns Street, Toronto")
        )

        mMap.addMarker(
            MarkerOptions().position(cruise2)
                .title("Toronto Cruises 2")
                .snippet("+12345678, 21 St.Johns Street, Toronto")
        )

        mMap.addMarker(
            MarkerOptions().position(cruise3)
                .title("Toronto Cruises 3")
                .snippet("+12345678, 21 St.Johns Street, Toronto")
        )

        mMap.addMarker(
            MarkerOptions().position(cruise4)
                .title("Toronto Cruises 4")
                .snippet("+12345678, 21 St.Johns Street, Toronto")
        )

        mMap.addMarker(
            MarkerOptions().position(cruise5)
                .title("Toronto Cruises 5")
                .snippet("+12345678, 21 St.Johns Street, Toronto")
        )


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cruise1, zoomLevel))
    }
}
