package com.example.contact_manager_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class pageafterlogin : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pageafterlogin)
        val name=intent.getStringExtra(MainActivity2.KEY1)
        val mail=intent.getStringExtra(MainActivity2.KEY2)

        val username=findViewById<TextView>(R.id.username)
        val useremail=findViewById<TextView>(R.id.useremail)

        username.text="Welcome !!! $name"
        useremail.text="Your Email Address is $mail"


    }
}