package com.example.consumocombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResultado : TextView = findViewById(R.id.txtResult)
        val resultado = intent.getFloatExtra("EXTRA_RESULTADO", 0.1f)

        tvResultado.text = resultado.toString()

    }
}