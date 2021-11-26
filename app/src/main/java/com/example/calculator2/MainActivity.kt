package com.example.calculator2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val one = findViewById<TextView>(R.id.one)
        val two = findViewById<TextView>(R.id.two)
        val three = findViewById<TextView>(R.id.three)
        val four = findViewById<TextView>(R.id.four)
        val five = findViewById<TextView>(R.id.five)
        val six = findViewById<TextView>(R.id.six)
        val seven = findViewById<TextView>(R.id.seven)
        val eight = findViewById<TextView>(R.id.eight)
        val nine = findViewById<TextView>(R.id.nine)
        val num1  = findViewById<TextView>(R.id.tv1)
        val num2 = findViewById<TextView>(R.id.tv2)

        val decimal = findViewById<TextView>(R.id.decimal)
        val back = findViewById<TextView>(R.id.back)
        val clear = findViewById<TextView>(R.id.clear)

        val equal = findViewById<TextView>(R.id.equals)
        val zero = findViewById<TextView>(R.id.zero)
        val ans = findViewById<TextView>(R.id.ans)

        clear.setOnClickListener {
            num1.text = ""
            num2.text = ""
            ans.text = ""

        }

        one.setOnClickListener { input("1") }
        zero.setOnClickListener { input("0") }
        two.setOnClickListener { input("2") }
        three.setOnClickListener { input("3") }
        four.setOnClickListener { input("4") }
        five.setOnClickListener { input("5") }
        six.setOnClickListener { input("6") }
        seven.setOnClickListener { input("7") }
        eight.setOnClickListener { input("8") }
        nine.setOnClickListener { input("9") }
        back.setOnClickListener {
            if(findViewById<RadioButton>(R.id.number1).isChecked){
                if(num1.text.isNotEmpty()){
                    num1.text = num1.text.substring(0,num1.text.length-1)
                }
            }
            else{
                if(num2.text.isNotEmpty()){
                    num2.text = num2.text.substring(0,num2.text.length-1)
                }
            }


        }
        equal.setOnClickListener {
            if(num1.text.isEmpty()||num2.text.isEmpty()){
                message(this,"please fill both the numbers")

            }
            else{
                try {
                    val str = num1.text.toString()
                    val n1 = str.toDouble()
                    val n2 = num2.text.toString().toDouble()

                    when {
                        findViewById<RadioButton>(R.id.addition).isChecked -> {
                            ans.text = (n1+n2).toString()
                        }
                        findViewById<RadioButton>(R.id.product).isChecked -> {
                            ans.text = (n1*n2).toString()
                        }
                        findViewById<RadioButton>(R.id.substract).isChecked -> {
                            ans.text = (n1-n2).toString()
                        }
                        else -> {
                            ans.text = (n1/n2).toString()
                        }
                    }

                }
                catch (e:Exception){
                    message(this,"Please write valid Expression")
                    num1.text = ""
                    num2.text = ""
                    ans.text = ""

                }
            }


        }

        decimal.setOnClickListener { input(".") }

    }

    private fun input(s:String?){
       if(findViewById<RadioButton>(R.id.number1).isChecked){
           val num1 = findViewById<TextView>(R.id.tv1)
           num1.text =num1.text.toString()+s
       }
        else {
            val num2 = findViewById<TextView>(R.id.tv2)
           num2.text = num2.text.toString()+s
       }


    }





}