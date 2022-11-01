package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var result: TextView
    private lateinit var clickedView: View
    private var operand = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result1)
    }

    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {
            var text = result.text.toString()
            val number = clickedView.text.toString()
            if (text == "0") {
                text = ""
            }
            val Result = text + number
            result.text = Result

        }
    }

    fun opoerationClick(clickedView: View) {
        if (clickedView is TextView) {
            operand = result.text.toString().toDouble()
            operation = clickedView.text.toString()
        }
    }

    fun equalsClick(clickedView: View){
        val secondOperand = result.text.toString().toDouble()
        when (operation) {
            "+" -> result.text = (operand + secondOperand).toString()
            "-" -> result.text = (operand - secondOperand).toString()
            "*" -> result.text = (operand * secondOperand).toString()
            "/" -> result.text = (operand / secondOperand).toString()
        }
    }

}
