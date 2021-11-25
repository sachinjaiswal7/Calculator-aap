package com.example.calculator2

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Activity.message(context:Context,s:String){
    Toast.makeText(context,s,Toast.LENGTH_LONG).show()
}