package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import com.example.myapplication.R.id.editText


val sistemaChet = arrayOf( "2" , "8" , "16")
var operand1= 0
var sistemi = sistemaChet [0]
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spiner = findViewById<Spinner>(R.id.spinner)
        val textView = findViewById<TextView>(R.id.textView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item , sistemaChet )
        spiner.adapter = adapter

        spiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                sistemi = sistemaChet[position]
                render()
            }
        }
        val editText1= findViewById<EditText>(editText)
        editText1.doAfterTextChanged {
            operand1= it.toString().toIntOrNull() ?: 0
            render()
        }
    }
    fun render() {
        var result1 = 0
        var result2 = 0
        var result3 = 0
        val textView = findViewById<TextView>(R.id.textView)
        when(sistemi){
            sistemaChet[0] -> {
                result1 = operand1
                textView.text = result1.toString(2)
            }
            sistemaChet[1] -> {
                result2 = operand1
                textView.text = result2.toString(8)
            }
            sistemaChet[2] -> {
                result3 = operand1
                textView.text = result3.toString(16)
            }
        }









    }
}