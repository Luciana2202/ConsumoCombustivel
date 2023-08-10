package com.example.consumocombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResultado : TextView = findViewById(R.id.txtResult)
        val resultado = intent.getFloatExtra("EXTRA_RESULTADO", 0.1f)

        val resultadoFinal = "R$ %.2f".format(resultado)
        tvResultado.text = resultadoFinal

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}