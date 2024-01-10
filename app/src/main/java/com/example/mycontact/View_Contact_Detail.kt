package com.example.mycontact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class View_Contact_Detail : AppCompatActivity() {

    lateinit var frstName: TextView
    lateinit var lstName: TextView
    lateinit var phnum: TextView
    lateinit var button1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_contact_detail)

        val actionbar = supportActionBar

        actionbar?.setDisplayHomeAsUpEnabled(true)


        frstName = findViewById(R.id.textView9)
        lstName = findViewById(R.id.textView10)
        phnum= findViewById(R.id.textView11)
        button1=findViewById(R.id.button2)

        val contDt = intent.getParcelableExtra<Contact>("newList")
        if(contDt!=null){
            frstName.text=contDt.fName
            lstName.text = contDt.lname
            phnum.text= contDt.phone
        }
        button1.setOnClickListener{

            var uri = Uri.parse("tel:${contDt?.phone}")
            var i = Intent(Intent.ACTION_DIAL,uri)
            startActivity(i)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}


