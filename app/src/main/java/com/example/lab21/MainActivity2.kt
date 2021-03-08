package com.example.lab21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2: AppCompatActivity() {

    private var n1: Double = 0.0
    private var n2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnUno.setOnClickListener {numeroPress("1")}
        btnDos.setOnClickListener { numeroPress("2") }
        btnTres.setOnClickListener { numeroPress("3") }
        btnCuatro.setOnClickListener { numeroPress("4") }
        btnCinco.setOnClickListener { numeroPress("5") }
        btnSeis.setOnClickListener { numeroPress("6") }
        btnSiete.setOnClickListener { numeroPress("7") }
        btnOcho.setOnClickListener { numeroPress("8") }
        btnNueve.setOnClickListener { numeroPress("9") }
        btnCero.setOnClickListener { numeroPress("0") }

        btnSuma.setOnClickListener { operacionPress(SUMA) }
        btnResta.setOnClickListener { operacionPress(RESTA) }

        btnBorrar.setOnClickListener {
            n1 = 0.0
            n2 = 0.0
            tvProceso.text = "0"
            operacion = NOP
        }

        btnIgual.setOnClickListener {
            var resultado = when(operacion){
                SUMA -> n1 + n2
                RESTA -> n1 - n2
                else -> 0
            }
            tvProceso.text = resultado.toString()
        }


    }
    private fun numeroPress(digito: String){
        tvProceso.text = "${tvProceso.text}$digito"
        if(operacion == NOP){
            n1 = tvProceso.text.toString().toDouble()
        }
        else{
            n2 = tvProceso.text.toString().toDouble()
        }
    }

    private fun operacionPress(operacion: Int){
        this.operacion = operacion

        n1 = tvProceso.text.toString().toDouble()
        tvProceso.text = "0"
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val NOP = 4

    }

}