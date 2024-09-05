package com.example.brentfueller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userPhone: EditText = findViewById(R.id.phone)

        val button: Button = findViewById(R.id.button_login)

        val checkBoxRools: CheckBox = findViewById(R.id.checkBox)
        val intent = Intent(this, MainActivity2::class.java)

        button.setOnClickListener {
            val phone = userPhone.text.toString().trim()
            if(phone == "9000000000") {
                Toast.makeText(this, "Отлично", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Неверный номер телефона", Toast.LENGTH_LONG).show()
            }
        }
        userPhone.setOnKeyListener(View.OnKeyListener { _, _, _ ->
            val phone = userPhone.text.toString().trim()
            if(phone.length == 10) {
                button.isEnabled = checkBoxRools.isChecked
            }
            false
        })

        checkBoxRools.setOnClickListener {
            if(checkBoxRools.isChecked) {
                val phone = userPhone.text.toString().trim()
                button.isEnabled = phone.length == 10
            }
        }
    }
}