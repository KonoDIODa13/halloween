package com.example.halloween

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.halloween.modelo.Persona
import kotlin.math.roundToInt
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sustos_que_dan_gusto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val iconsTruco: List<String> =
            listOf(
                "\uD83C\uDF83",
                "\uD83D\uDC7B",
                "\uD83E\uDD87",
                "\uD83D\uDC80",
                "\uD83D\uDD77\uFE0F",
                "\uD83D\uDD78\uFE0F"
            )

        val iconsTrato: List<String> =
            listOf(
                "\uD83C\uDF70",
                "\uD83C\uDF6C",
                "\uD83C\uDF61",
                "\uD83C\uDF6D",
                "\uD83C\uDF6A",
                "\uD83C\uDF6B",
                "\uD83E\uDDC1",
                "\uD83C\uDF69",
            )

        val p = Persona("jaime", 22, 180.00)
        val p2 = Persona("miguel", 27, 175.00)
        /*
        val p3 = Persona("jaime", 22, 180.00)
        val p4 = Persona("jaime", 22, 180.00)
        */
        val listaPersona = listOf(p, p2)

        val tvSustos = findViewById<TextView>(R.id.tvSustos)
        val tvDulces = findViewById<TextView>(R.id.tvDulces)
        val btnTruco = findViewById<Button>(R.id.btnTruco)
        val btnTrato = findViewById<Button>(R.id.btnTrato)
        val sustos = findViewById<TextView>(R.id.tvResultado)

        tvSustos.text = "Sustos: " + iconsTruco.toString()
        tvDulces.text = "Dulces: " + iconsTrato.toString()
        btnTruco.setOnClickListener {
            sustos.text = mostrarSustosByTruco(listaPersona, iconsTruco)
        }

        btnTrato.setOnClickListener {
            sustos.text = mostrarSustosByTrato(listaPersona, iconsTrato)
        }

    }

    fun mostrarSustosByTruco(personas: List<Persona>, icons: List<String>): String {
        var texto = ""
        texto += sustosByNombre(personas, icons)
        texto += sustosByEdad(personas, icons)
        texto += sustosByAltura(personas, icons)
        return texto
    }

    fun sustosByNombre(personas: List<Persona>, icons: List<String>): String {
        var texto = ""
        var nombres = ""
        personas.forEach { persona ->
            nombres += persona.nombre
        }
        for (i in 1..nombres.length) {
            if (nombres.length >= 2) {
                texto += getSusto(icons)
                nombres = nombres.removeRange(0, 2)
            }
        }
        return texto
    }

    fun sustosByEdad(personas: List<Persona>, icons: List<String>): String {
        var texto = ""
        personas.forEach { persona ->
            if (persona.edad % 2 == 0) {
                texto += getSusto(icons) + getSusto(icons)
            }
        }
        return texto
    }

    fun sustosByAltura(personas: List<Persona>, icons: List<String>): String {
        var texto = ""
        var alturas = 0.0
        personas.forEach { persona ->
            alturas += persona.altura
        }
        if (alturas >= 100.00) {
            texto += getSusto(icons) + getSusto(icons) + getSusto(icons)

        }
        return texto
    }

    fun mostrarSustosByTrato(personas: List<Persona>, icons: List<String>): String {
        var texto = ""
        texto += dulcesByNombre(personas, icons)
        texto += dulcesByEdad(personas, icons)
        texto += dulcesByAltura(personas, icons)
        return texto
    }

    fun dulcesByNombre(personas: List<Persona>, icons: List<String>): String {
        var texto = ""
        personas.forEach { persona ->
            for (i in 1..persona.nombre.length) {
                texto += getDulce(icons)
            }
        }
        return texto
    }

    fun dulcesByEdad(personas: List<Persona>, icons: List<String>): String {
        var texto = ""
        personas.forEach { persona ->
            for (i in 1..persona.edad) {
                if (i % 3 == 0 && i <= 10)
                    texto += getDulce(icons)
            }
        }
        return texto
    }

    fun dulcesByAltura(personas: List<Persona>, icons: List<String>): String {
        var texto = ""
        personas.forEach { persona ->
            for (i in 1..persona.altura.roundToInt()) {
                if (i % 50 == 0 && i <= 150)
                    texto += getDulce(icons) + getDulce(icons)
            }
        }
        return texto
    }

    fun getSusto(icons: List<String>): String {
        return icons[Random.nextInt(0, icons.size)]
    }

    fun getDulce(icons: List<String>): String {
        return icons[Random.nextInt(0, icons.size)]
    }
}