package com.example.brentfueller

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userCode: EditText = findViewById(R.id.code)
        val button: Button = findViewById(R.id.button_code)

        val intent = Intent(this, MainActivity3::class.java)

        button.setOnClickListener {
            startActivity(intent)
        }

        userCode.setOnKeyListener(View.OnKeyListener { _, _, _ ->
            val code = userCode.text.toString().trim()
            if(code.length == 6) {
                button.isEnabled = (code == "123456")
            }
            false
        })
    }
}