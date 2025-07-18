package com.example.lister.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lister.R

class CustomAdapter(private val mList: List<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    // Holds the view for an item
    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        // Get references to elements in our list item
        val titleTextView = itemView.findViewById<TextView>(R.id.title_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the UI and return individual list item to show
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Update individual list items content
        val country = mList[position]
        holder.titleTextView.text = country
    }

    override fun getItemCount(): Int {
        // Return number of items to display
        return mList.count();
    }

}