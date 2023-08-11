package com.example.consumocombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CompararActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar)

        val editAlcool: EditText = findViewById(R.id.editAlcool)
        val editGasolina: EditText = findViewById(R.id.editGasolina)
        val btnComparar: Button = findViewById(R.id.btnComparar)
        val txtResultado: TextView = findViewById(R.id.txtResultado)

        btnComparar.setOnClickListener {
            val alcoolValue = editAlcool.text.toString().toFloatOrNull()
            val gasolinaValue = editGasolina.text.toString().toFloatOrNull()

            if (alcoolValue != null && gasolinaValue != null) {
                val resultado = if (alcoolValue / gasolinaValue < 0.7) {
                    "Abasteça com Álcool"
                } else {
                    "Abasteça com Gasolina"
                }
                txtResultado.text = resultado
                txtResultado.visibility = View.VISIBLE
            } else {
                txtResultado.text = "Valores inválidos"
                txtResultado.visibility = View.VISIBLE
            }
        }
    }
}


