package com.example.calculator2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
     var   numberchoose: String =findViewById<RadioGroup>(R.id.rdgroup1).checkedRadioButtonId.toString()

     var  signchoose: String = findViewById<RadioGroup>(R.id.rdgroup2).checkedRadioButtonId.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberchoose = findViewById<RadioGroup>(R.id.rdgroup1).checkedRadioButtonId.toString()
        signchoose = findViewById<RadioGroup>(R.id.rdgroup2).checkedRadioButtonId.toString()
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
            if(numberchoose.equals("number1")){
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
                    when(signchoose){
                        "product"-> ans.text = (n1*n2).toString()
                        "addition"-> ans.text = (n1+n2).toString()
                        "division"-> ans.text = (n1/n2).toString()
                        "substract" -> ans.text = (n1-n2).toString()
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

    @SuppressLint("SetTextI18n")
    private fun input(s:String?){
       if(numberchoose == "number1"){
           val num1 = findViewById<TextView>(R.id.tv1)
           num1.append(s)
       }
        else if(numberchoose == "number2"){
            val num2 = findViewById<TextView>(R.id.tv2)
           num2.append(s)
       }
        else{
            message(this,numberchoose)
       }

    }

    fun numberchooser(view: android.view.View) {
        val rdgroup = findViewById<RadioGroup>(R.id.rdgroup1)
        numberchoose = rdgroup.checkedRadioButtonId.toString()

    }

    fun signchooser(view: android.view.View) {
        signchoose = findViewById<RadioGroup>(R.id.rdgroup2).checkedRadioButtonId.toString()
    }

}