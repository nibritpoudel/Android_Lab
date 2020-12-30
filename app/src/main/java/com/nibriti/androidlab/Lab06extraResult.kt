package com.nibriti.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Lab06extraResult : AppCompatActivity() {

    private lateinit var tvName :TextView
    private lateinit var tvAddress :TextView
    private lateinit var tvGender :TextView
    private lateinit var tvMobile :TextView
    private lateinit var lsPerson :ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab06extra_result)

        tvName = findViewById(R.id.tvName)
        tvAddress = findViewById(R.id.tvAddress)
        tvGender = findViewById(R.id.tvGender)
        tvMobile = findViewById(R.id.tvMobile)
        lsPerson = findViewById(R.id.lsPerson)

        var data = intent.getSerializableExtra("data") as ArrayList<Person>

        var a = ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        lsPerson.adapter = a;

        lsPerson.setOnItemClickListener(object: AdapterView.OnItemClickListener{
            override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
//                Toast.makeText(this@Lab06,data.get(position).Name,Toast.LENGTH_SHORT).show()
                tvName.setText("Name: " + data.get(position).Name)
                tvAddress.setText("Address: " + data.get(position).Address)
                tvGender.setText("Gender: " + data.get(position).Gender)
                tvMobile.setText("Mobile: " + data.get(position).Mobile)
            }
        })
    }
}
