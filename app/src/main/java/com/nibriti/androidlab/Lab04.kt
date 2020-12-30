package com.nibriti.androidlab

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*
import java.util.Currency.getInstance

class Lab04 : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var tvJoindate: TextView
    private lateinit var tvAddress: AutoCompleteTextView
    private lateinit var spDepartment: Spinner
    private lateinit var btnSubmit: Button
    private lateinit var tvResult: TextView
    var selectedItem = ""
    var flag = true
    var chosenyear = 0
    var chosenmonth = 0
    var chosenday = 0
    private val department = arrayOf("Marketing", "Academic", "Faculty", "Management")
    private val address = arrayOf("Kathmandu", "Bhaktapur", "Janakpur", "Pokhara")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab04)

        etName = findViewById(R.id.etName)
        tvJoindate = findViewById(R.id.tvJoindate)
        tvAddress = findViewById(R.id.tvAddress)
        spDepartment = findViewById(R.id.spDepartment)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvResult = findViewById(R.id.tvResult)

        //For Spinner
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            department
        )
        spDepartment.adapter = adapter

        spDepartment.onItemSelectedListener=
            object : AdapterView.OnItemSelectedListener{

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    selectedItem = parent?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

        //For autocomplete textview
        val autoCompleteAdapter = ArrayAdapter(

            this,
            android.R.layout.simple_dropdown_item_1line, address
        )
        tvAddress.setAdapter(autoCompleteAdapter)
        tvAddress.threshold=1


        //For Date picker
        tvJoindate.setOnClickListener {
                loadCalendar()

        }

        btnSubmit.setOnClickListener {

            tvResult.text = "Employee name : " + etName.text + "\n Department : " + selectedItem + "\n Address : " + tvAddress.text + "\n Join Date : " + tvJoindate.text
        }

    }

    private fun loadCalendar() {

            val c = Calendar.getInstance()
            var currentYear = c.get(Calendar.YEAR)
            var currentMonth = c.get(Calendar.MONTH)
            var currentDay = c.get(Calendar.DAY_OF_MONTH)

        if (!flag) {
            currentYear = chosenyear
            currentMonth = chosenmonth
            currentDay = chosenday
        }
            val datePickerDialog = DatePickerDialog (
                this,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                   chosenday = dayOfMonth
                    chosenmonth = monthOfYear
                    chosenyear = year
                    tvJoindate.text = "$dayOfMonth/${monthOfYear+1}/$year"
                },
                currentYear,
                currentMonth,
                currentDay
            )
            datePickerDialog.show()
            flag = false
        }
}

