package com.example.lister.activities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lister.R
import com.example.lister.model.Country

class CountryDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_country_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nameTextView = findViewById<TextView>(R.id.title_value_text_view)
        val codeTextView = findViewById<TextView>(R.id.code_value_text_view)
        val populationTextView = findViewById<TextView>(R.id.population_value_text_view)
        val languagesTextView = findViewById<TextView>(R.id.languages_value_text_view)
        val descTextView = findViewById<TextView>(R.id.desc_value_text_view)

        // Set data from selected country object
        val country = intent.extras?.get("EXTRA_COUNTRY") as Country
        nameTextView.text = country.name
        codeTextView.text = country.code
        populationTextView.text = country.population.toString()

        // Handle mark button action
        val markButton = findViewById<Button>(R.id.mark_button)
        markButton.setOnClickListener(View.OnClickListener {
            // Mark the country as true and return the result
            country.marked = true
            val intent = Intent()
            intent.putExtra("EXTRA_COUNTRY", country)
            setResult(Activity.RESULT_OK, intent)
            finish()
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        // For navigation back action
        onBackPressed()
        return true
    }

}








