package com.example.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // 0-> nada 1->suma 2->resta 3->multiplicacion 4->divicion
    var operacion: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val btnBorrar: Button = findViewById(R.id.Borrar)
        val btnIgual: Button = findViewById(R.id.Igual)

        btnIgual.setOnClickListener{
            var numero2: Double = tv_num2.text.toString().toDouble()
            var respuesta:Double = 0.0

            when(operacion){
                1-> respuesta = numero1 + numero2
                2-> respuesta = numero1 - numero2
                3-> respuesta = numero1 * numero2
                4-> respuesta = numero1 / numero2
            }
            tv_num2.setText(respuesta.toString())
            tv_num1.setText("")
        }
        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 =0.0
            operacion = 0
        }
    }
    fun precionarDigito(view : View){
       // val tv_num2 : TextView = findViewById(R.id.tv_num2)
        var num2: String = tv_num2.text.toString()

        when(view.id){
            R.id.Cero -> tv_num2.setText(num2 + "0")
            R.id.Uno -> tv_num2.setText(num2 + "1")
            R.id.Dos -> tv_num2.setText(num2 + "2")
            R.id.Tres -> tv_num2.setText(num2 + "3")
            R.id.Cuatro -> tv_num2.setText(num2 + "4")
            R.id.Cinco -> tv_num2.setText(num2 + "5")
            R.id.Seis -> tv_num2.setText(num2 + "6")
            R.id.Siete -> tv_num2.setText(num2 + "7")
            R.id.Ocho -> tv_num2.setText(num2 + "8")
            R.id.Nueve -> tv_num2.setText(num2 + "9")
            R.id.Punto -> tv_num2.setText(num2 + ".")
        }
    }
    fun clicOperacion(view : View){
        numero1 = tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")
        when(view.id){
           R.id.Suma->{
               tv_num1.setText(num2_text + "+")
               operacion = 1
           }
            R.id.Restar->{
                tv_num1.setText(num2_text + "-")
                operacion = 2
            }
            R.id.Multiplicar->{
                tv_num1.setText(num2_text + "*")
                operacion = 3
            }
            R.id.Dividir->{
                tv_num1.setText(num2_text + "/")
                operacion = 4
            }
        }
    }
}
