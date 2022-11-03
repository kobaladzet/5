package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast


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

    fun operationClick(clickedView: View) {
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
        if (result.text.toString().takeLast(2) == ".0") {
            result.text = result.text.toString().dropLast(2)
        }else if (result.text.toString() == "Infinity" || result.text.toString() == "NaN"){
            Toast.makeText(applicationContext,"ასეთი რიცხვი არ არსებობს", Toast.LENGTH_LONG).show()
        }
        else {result.text = result.text.toString()}

        operation = ""
        operand = 0.0

    }


    fun tvClear(clickedView: View){
        if (clickedView is TextView) {
            result.text = "0"
            operand = 0.0
            operation =""
        }
    }
    fun dot(clickedView: View){
        if (clickedView is TextView){
            if (result.text.toString() == "") {
                result.text = "0."
            } else if ("." !in result.text.toString()) {
                val newText = result.text.toString() + "."
                result.text = newText
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

