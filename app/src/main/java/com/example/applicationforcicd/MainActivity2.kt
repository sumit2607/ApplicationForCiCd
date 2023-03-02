package com.example.applicationforcicd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.compose.material3.Button


class MainActivity2 : AppCompatActivity() {


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val button : Button = findViewById(R.id.button)
        button.setOnClickListener {
            throw Exception("chala jaaa")
        }
    }
}