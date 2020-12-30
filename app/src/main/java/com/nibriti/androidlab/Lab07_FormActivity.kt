package com.nibriti.androidlab

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class Lab07_FormActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_lab07__form)

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
//            list.add(person)
            var intent = Intent()
            intent.putExtra("data",person) //Person data is added to the send back
            setResult(Activity.RESULT_OK,intent);
            finish()
//            startActivity(
//                Intent(this,Lab07_MainActivity::class.java)
//                .putExtra("data",list))
        }


    }
}