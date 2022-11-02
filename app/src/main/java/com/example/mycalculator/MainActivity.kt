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
        if (clickedView is TextView){
            if (result.text.toString() != "") {
                operand = result.text.toString().toDouble()
                result.text = ""
                operation = clickedView.text.toString()
            }
            else {operation = clickedView.text.toString() }

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
        result.text.toString()
        if (result.toString().slice(result.text.toString().length - 2 until result.toString().length) == ".0") {
            result.text = result.text.toString().dropLast(2)
        }

    }


    fun tvClear(clickedView: View){
        if (clickedView is TextView) {
            result.text = "0"
        }
    }
    fun dot(clickedView: View){
        if (clickedView is TextView){
            if (result.text.toString() == "") {
                result.text = "0."
            } else if ("." !in result.text.toString()) {
                val tempText = result.text.toString() + "."
                result.text = tempText
            }
        }
    }
    fun clickDel(clickedView: View){
        if (clickedView is TextView)
            if(result.text.toString() != "0") {
                result.text = result.text.toString().dropLast(1)

            }else if (result.text.toString() == "")
                result.text = "0"
    }

}

