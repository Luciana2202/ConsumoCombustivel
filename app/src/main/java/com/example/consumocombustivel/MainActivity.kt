package com.example.consumocombustivel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular : Button =findViewById(R.id.botaoCalcular)
        val edtDistancia : EditText = findViewById(R.id.edtKm)
        val edtValorLitros : EditText = findViewById(R.id.edtLitros)
        val edtRendimentoCarro : EditText = findViewById(R.id.edtRendimento)

        btnCalcular.setOnClickListener{

            val trajeto: Float = edtDistancia.text.toString().toFloat()
            val rendimento: Float = edtRendimentoCarro.text.toString().toFloat()
            val valorCombustível: Float = edtValorLitros.text.toString().toFloat()
            val resultado: Float = (trajeto / rendimento) * valorCombustível



            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULTADO", resultado)
                }
            startActivity(intent)

        }

    }
}