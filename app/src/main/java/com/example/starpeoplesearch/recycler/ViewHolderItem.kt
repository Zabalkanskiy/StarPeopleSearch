package com.example.starpeoplesearch.recycler

import android.view.TextureView
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starpeoplesearch.R

class ViewHolderItem(view: View) : RecyclerView.ViewHolder(view) {
    val name = view.findViewById<TextView>(R.id.item_name)
    val information = view.findViewById<TextView>(R.id.item_information)
    val flavoredCheckBox = view.findViewById<CheckBox>(R.id.item_favorite)
}