package com.example.lister.model

import java.io.Serializable

class Country (val name: String, val code: String, val population: Int) : Serializable{
    var languagees: List<String> = mutableListOf<String>()
    var description: String = ""
    var marked: Boolean = false
}