package com.example.lister.activities

import android.app.Activity
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lister.R
import com.example.lister.adapters.CountryListAdapter
import com.example.lister.adapters.CountryListClickListener
import com.example.lister.model.Country

class MainActivity : AppCompatActivity(), CountryListClickListener {

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Get reference to recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.list_view)
        recyclerView.setHasFixedSize(true)
        // Assign layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Setup data and adapter
        val countryList = mutableListOf<Country>(
            Country("Australia" ,"AU", 12222222),
            Country("England", "UK", 23612538),
            Country("Sri Lanka", "LK", 2000000),
            Country("India", "IN", 121356546),
            Country("Pakistan", "PK", 3223344),
            Country("West Indies", "WI", 124276),
            Country("Ireland", "IR", 31432532),
            Country("Jamaica", "JM", 12445512),
            Country("Japan", "JA" , 121344),
            Country("Netherland", "NL", 134466),
            Country("Scotland", "SC", 23423467),
            Country("South Africa", "SA", 365487),
            Country("South Korea", "SK", 456363),
            Country("UAE", "UA", 346764189),
            Country("USA", "US", 2352874),
            Country("Zimbabwe", "ZI", 541796189),
            Country("Mexico", "MX", 33333333),
            Country("Bangladesh", "BA", 2352874),
            Country("Nepal", "NP", 34333333)
        )
        recyclerView.adapter = CountryListAdapter(countryList, this)

    }

    override fun onCountryClick(country: Country) {
        // Move to country detail view with info from selection
        val intent = Intent(this, CountryDetailActivity::class.java)
        intent.putExtra("EXTRA_COUNTRY", country)
        resultLauncher.launch(intent)
    }

    // country detail activity launcher to handle results
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == Activity.RESULT_OK){
            // There's a valid result
            Log.d(TAG, "Country Marked!")
            val toast = Toast.makeText(this, getString(R.string.country_marked), Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}