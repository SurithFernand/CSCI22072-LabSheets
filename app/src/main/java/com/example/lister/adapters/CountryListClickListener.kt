package com.example.lister.adapters

import com.example.lister.model.Country

/***
 * Interface to notify when list item is clicked
 */

interface CountryListClickListener {
    fun onCountryClick(country: Country)
}