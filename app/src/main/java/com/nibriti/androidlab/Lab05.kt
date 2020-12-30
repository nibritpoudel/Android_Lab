package com.nibriti.androidlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView

class Lab05 : AppCompatActivity() {
    private lateinit var rbStudent : RadioButton
    private lateinit var rbStaff : RadioButton
    private lateinit var tvStudentId : TextView
    private lateinit var tvBatch : TextView
    private lateinit var spBatch : Spinner
    private lateinit var etStudentId : EditText
    private val batch = arrayOf("24A", "24B", "25A", "25B")
    private val department = arrayOf("Academic", "Faculty", "Management", "Operation")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab05)

        rbStudent = findViewById(R.id.rbStudent)
        rbStaff = findViewById(R.id.rbStaff)
        tvBatch = findViewById(R.id.tvBatch)
        tvStudentId = findViewById(R.id.tvStudentId)
        etStudentId = findViewById(R.id.etStudentId)
        spBatch = findViewById(R.id.spBatch)

        rbStudent.setOnClickListener {
            tvBatch.text = "Batch"
            tvStudentId.visibility = View.VISIBLE
        }




    }
}