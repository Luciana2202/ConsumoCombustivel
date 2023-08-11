package com.example.consumocombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular : Button =findViewById(R.id.botaoCalcular)
        val btnAlcoolGasolina : Button = findViewById(R.id.btnAlcoolGasolina)
        val edtDistancia : EditText = findViewById(R.id.edtDistancia)
        val edtPrecoLitros : EditText = findViewById(R.id.edtPrecoLitro)
        val edtConsumoMedio : EditText = findViewById(R.id.edtConsumo)

        btnCalcular.setOnClickListener{

            val distanciaStr = edtDistancia.text.toString()
            val consumoStr = edtConsumoMedio.text.toString()
            val precoLitrosStr = edtPrecoLitros.text.toString()

            if (distanciaStr.isNotEmpty() &&
                consumoStr.isNotEmpty() &&
                precoLitrosStr.isNotEmpty()) {

                val distancia: Float = distanciaStr.toFloat()
                val consumo: Float = consumoStr.toFloat()
                val precoLitro: Float = precoLitrosStr.toFloat()

                val resultado: Float = (distancia / consumo) * precoLitro

                val intent = Intent(this, ResultActivity::class.java)

                    .apply {
                        putExtra("EXTRA_RESULTADO", resultado)
                    }
                startActivity(intent)
            } else
            {
                Toast.makeText(this,
                    "Preencha todos os campos.",
                    Toast.LENGTH_LONG).show()
            }

        }

        val botaoAlcoolGasolina : Button = findViewById(R.id.btnAlcoolGasolina)
        botaoAlcoolGasolina.setOnClickListener {
            val intent = Intent(this, CompararActivity::class.java)
            startActivity(intent)
        }

    }
}