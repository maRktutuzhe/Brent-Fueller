package com.example.brentfueller

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MapActivity", "onCreate called")
        MapKitFactory.setApiKey("19b04bb5-0637-4beb-b0b5-1afdeda9477c")
        MapKitFactory.initialize(this)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mapView: MapView = findViewById(R.id.mapView)
        mapView.mapWindow.map.move(CameraPosition(Point(51.770404, 55.103080), 11.0f, 0.0f, 0.0f))
        val imageProvider = ImageProvider.fromResource(this, R.drawable.baseline_location_on_24)
        val placemark1 = mapView.mapWindow.map.mapObjects.addPlacemark().apply {
            geometry = Point(51.782739, 55.083512)
            setIcon(imageProvider)
        }
        val placemark2 = mapView.mapWindow.map.mapObjects.addPlacemark().apply {
            geometry = Point(51.782004, 55.169370)
            setIcon(imageProvider)
        }
        val placemark3 = mapView.mapWindow.map.mapObjects.addPlacemark().apply {
            geometry = Point(51.811525, 55.093626)
            setIcon(imageProvider)
        }

    }
    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        val mapView: MapView = findViewById(R.id.mapView)
        mapView.onStart()
        Log.d("MapActivity", "onStart called")
    }

    override fun onStop() {
        val mapView: MapView = findViewById(R.id.mapView)
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
        Log.d("MapActivity", "onStop called")
    }
}