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
        val edtDistancia : EditText = findViewById(R.id.edtKm)
        val edtValorLitros : EditText = findViewById(R.id.edtLitros)
        val edtRendimentoCarro : EditText = findViewById(R.id.edtRendimento)

        btnCalcular.setOnClickListener{

            val trajetoStr = edtDistancia.text.toString()
            val rendimentoStr = edtRendimentoCarro.text.toString()
            val valorCombustivelStr = edtValorLitros.text.toString()

            if (trajetoStr.isNotEmpty() && rendimentoStr.isNotEmpty() &&
                valorCombustivelStr.isNotEmpty()) {
                val trajeto: Float = trajetoStr.toFloat()
                val rendimento: Float = rendimentoStr.toString().toFloat()
                val valorCombustível: Float = valorCombustivelStr.toFloat()
                val resultado: Float = (trajeto / rendimento) * valorCombustível

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULTADO", resultado)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos.", Toast.LENGTH_LONG).show()
            }

        }

    }
}