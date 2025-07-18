package com.example.lister.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lister.R
import com.example.lister.adapters.CustomAdapter

class MainActivity : AppCompatActivity() {
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
        val countryList = mutableListOf<String>("Australia", "England", "Sri Lanka",
            "India", "Pakistan", "West Indies", "Ireland", "Jamaica", "Japan", "Netherland",
            "Scotland", "South Africa", "South Korea", "UAE", "UK", "USA", "Zimbabwe")
        recyclerView.adapter = CustomAdapter(countryList)

    }
}