package com.example.halloween

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.halloween.modelo.Persona

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sustos_que_dan_gusto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val p = Persona("jaime", 22, 180.00)
        val p2 = Persona("jaime", 22, 180.00)
        val p3 = Persona("jaime", 22, 180.00)
        val p4 = Persona("jaime", 22, 180.00)
        val listaPersona = List<Persona>(p,p2,p3,p4)
        val btnTruco = findViewById<Button>(R.id.btnTruco)
        val btnTrato = findViewById<Button>(R.id.btnTrato)


        btnTruco.setOnClickListener {

        }
    }

}