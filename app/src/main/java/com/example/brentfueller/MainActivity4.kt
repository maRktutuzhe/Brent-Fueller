package com.example.brentfueller

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("19b04bb5-0637-4beb-b0b5-1afdeda9477c")
        MapKitFactory.initialize(this)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = Intent(this, MainActivity3::class.java)
        val menu: Button = findViewById(R.id.menu)
        menu.setOnClickListener {
            startActivity(intent)
        }

        val mapView: MapView = findViewById(R.id.mapView)
        mapView.mapWindow.map.setNightModeEnabled(true);
        mapView.mapWindow.map.move(CameraPosition(Point(51.770404, 55.103080), 11.0f, 0.0f, 0.0f))

        val originalBitmap = BitmapFactory.decodeResource(resources, R.drawable.location)
        val resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, 64, 64, false)

        val imageProvider = ImageProvider.fromBitmap(resizedBitmap)
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
    }

    override fun onStop() {
        val mapView: MapView = findViewById(R.id.mapView)
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}