package com.nibriti.androidlab

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Lab07_MainActivity : AppCompatActivity() {

    private lateinit var btnAdd: Button
    private lateinit var tvName: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvGender: TextView
    private lateinit var tvMobile: TextView
    private lateinit var lsPerson: ListView
    var persons = arrayListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab07__main)

        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvGender = findViewById(R.id.tvGender)
        tvMobile = findViewById(R.id.tvMobile)
        lsPerson = findViewById(R.id.lsPerson)
        btnAdd = findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener {
            startActivityForResult(
                Intent(this, Lab07_FormActivity::class.java),1
            )
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                var person = data?.getSerializableExtra("data") as Person
                println(person.Name)
                persons.add(person);
                var a = ArrayAdapter(this, android.R.layout.simple_list_item_1, persons);
                lsPerson.adapter = a;
                lsPerson.setOnItemClickListener(object : AdapterView.OnItemClickListener {
                    override fun onItemClick(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        Toast.makeText(
                            this@Lab07_MainActivity,
                            persons.get(position).Name,
                            Toast.LENGTH_SHORT
                        ).show()
                        tvName.setText(persons.get(position).Name)
                        tvAddress.setText(persons.get(position).Address)
                        tvGender.setText(persons.get(position).Gender)
                        tvMobile.setText(persons.get(position).Mobile)
                    }
                })
            }
        }
    }
}