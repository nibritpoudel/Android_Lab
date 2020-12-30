package com.nibriti.androidlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import java.io.Serializable

class Lab06 : AppCompatActivity() {

    private lateinit var btnSubmit : Button
    private lateinit var etName : EditText
    private lateinit var etAddress : EditText
    private lateinit var etMobile : EditText
    private lateinit var rbMale : RadioButton
    private lateinit var rbFemale : RadioButton
    var list = arrayListOf<Person>()
    var gender :String = "female";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab06)

        btnSubmit = findViewById(R.id.btnSubmit)
        etName = findViewById(R.id.etName)
        etAddress = findViewById(R.id.etAddress)
        etMobile = findViewById(R.id.etMobile)
        rbFemale = findViewById(R.id.rbFemale)
        rbMale = findViewById(R.id.rbMale)

        rbMale.setOnClickListener {
            gender = "male"
        }
        rbFemale.setOnClickListener {
            gender = "female"
        }

        btnSubmit.setOnClickListener {
            var name = etName.text.toString()
            var address = etAddress.text.toString()
            var mobile = etMobile.text.toString()
            var person = Person(name, address, mobile, gender)
            list.add(person)
            startActivity(Intent(this,Lab06extraResult::class.java)
                .putExtra("data",list))

        }


    }
}