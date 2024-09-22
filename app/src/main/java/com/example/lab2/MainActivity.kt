package com.example.lab2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        val output: TextView = findViewById(R.id.output)
        val input_simbol: EditText = findViewById(R.id.input_simbol)
        val input_string: EditText = findViewById(R.id.input_string)
        val input_spsim: EditText = findViewById(R.id.input_spsim)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener{
            try {
                val sim = input_simbol.text.toString()
                val str = input_string.text.toString()
                val spsim = input_spsim.text.toString()
                val n = str.count()
                var k: String = ""
                val sim1 = sim[0];
                val spsim1 = spsim[0]
                for(i in 0..n-1){
                    if (str[i] == sim1){
                        k = k + spsim1
                    }
                    else{
                        k = k + str[i]
                    }
                }
                    output.text = k
            } catch (e: Exception) {
                output.text = "Ошибка."
            }
        }
    }
}