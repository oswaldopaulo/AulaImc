package com.oswaldopaulo.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){

        calcularBTN.setOnClickListener{
            val altura = alturaEDT.text.toString().toDouble()
            val peso  = pesoEDT.text.toString().toDouble()

            titleTXT.setText( imc(peso, altura).toString() )
        }
    }

    fun imc(peso: Double, altura :Double) : Double{
        fun Double.format(digits: Int) = "%.${digits}f".format(this).replace(',','.').toDouble()

        if(altura <= 0) return 0.00
        if(peso <= 0) return 0.00
        val res = peso / (altura).pow(2)
        return res.format(2)
    }
}