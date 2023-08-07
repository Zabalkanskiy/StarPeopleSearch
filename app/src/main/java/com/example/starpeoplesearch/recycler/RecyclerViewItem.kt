package com.example.starpeoplesearch.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starpeoplesearch.R
import com.example.starpeoplesearch.StarPeopleApplication
import com.example.starpeoplesearch.helper.Item

class RecyclerViewItem(var items : List<Item>) : RecyclerView.Adapter<ViewHolderItem>() {
    var filterList = mutableListOf<Item>()
    init {
        filterList = items.toMutableList()
    }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
            val view = LayoutInflater.from(StarPeopleApplication.getAppContext()).inflate(R.layout.item_recycler_view, parent, false)
            return ViewHolderItem(view)
    }

    override fun getItemCount(): Int {
     return   filterList.size
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        val positionItem =  filterList[position]
        holder.name.setText(positionItem.name)
        holder.information.setText((positionItem.information))
        holder.flavoredCheckBox.setOnClickListener{view ->
            filterList.get(position).favourite = !filterList.get(position).favourite
            //Нужно вставить логику щелчка нужно сохранить данные или в базе или в sharedPreferences

        }
        holder.flavoredCheckBox.isChecked = filterList.get(position).favourite

    }

    fun updateViewItem( newItem: List<Item>){
        filterList = newItem.toMutableList()
        notifyDataSetChanged()
    }
}