package com.nibriti.androidlab

import java.io.Serializable
import java.net.Inet4Address

class Person: Serializable {
    lateinit var Name : String;
    lateinit var Address : String;
    lateinit var Mobile : String;
    lateinit var Gender : String;

    constructor(name:String, address: String, mobile: String, gender: String ){
        this.Name = name;
        this.Address = address
        this.Gender = gender
        this.Mobile = mobile
    }

    override fun toString(): String {
        return Name;
    }

}