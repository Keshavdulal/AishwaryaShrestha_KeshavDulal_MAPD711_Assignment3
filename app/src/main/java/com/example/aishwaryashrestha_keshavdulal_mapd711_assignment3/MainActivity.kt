package com.example.aishwaryashrestha_keshavdulal_mapd711_assignment3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // list of cities
        val cityList = arrayListOf("Toronto", "Vancouver", "Quebec", "Montreal", "Ottawa")

        // listview
        val cityListView = findViewById<ListView>(R.id.cityListView)

        // adapter
        val cityAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cityList)
        // set adapter
        cityListView.adapter = cityAdapter

        cityListView.setOnItemClickListener { adapterView, view, i, id ->
            Toast.makeText(this@MainActivity, cityList[i], Toast.LENGTH_SHORT).show()

            println(">>" + cityList[i])
            var myIntentObject: Intent=Intent(this@MainActivity, MapsActivity::class.java)

            when (cityList[i]) {
                "Toronto" -> {
                     myIntentObject =
                        Intent(this@MainActivity, MapsActivity::class.java)
                }
                "Vancouver" -> {
                    myIntentObject =
                        Intent(this@MainActivity, Vancouver::class.java)
                }
                "Quebec" -> {
//                    selectedCity = LatLng(49.2827, 123.1207)
                    myIntentObject =
                        Intent(this@MainActivity, Quebec::class.java)
                }
                "Montreal" -> {
                    myIntentObject =
                        Intent(this@MainActivity, Montreal::class.java)
                }
                "Ottawa" -> {
                    myIntentObject =
                        Intent(this@MainActivity, Ottawa::class.java)

                }
            }
            myIntentObject.putExtra("cityIndex", i.toString())


            // Send intent object to MapsActivity
            startActivity(myIntentObject)
        }
    }
}
