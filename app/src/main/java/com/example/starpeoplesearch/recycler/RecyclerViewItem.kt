package com.example.starpeoplesearch.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starpeoplesearch.R
import com.example.starpeoplesearch.StarPeopleApplication
import com.example.starpeoplesearch.helper.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

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

            //Нужно вставить логику щелчка нужно сохранить данные или в базе или в sharedPreferences
            if (filterList.get(position).favourite){
                val itemIf = filterList.get(position)
                //???

                deleteFlavoredName(context = StarPeopleApplication.getAppContext(), item = itemIf)
                itemIf.favourite = !itemIf.favourite
            }else{
                val elseIf = filterList.get(position)
                elseIf.favourite = !elseIf.favourite
                saveFlavoredName(context = StarPeopleApplication.getAppContext(), item = elseIf)


            }
            //filterList.get(position).favourite = !filterList.get(position).favourite
        }
        holder.flavoredCheckBox.isChecked = filterList.get(position).favourite
    //    notifyDataSetChanged()

    }

    fun updateViewItem( newItem: List<Item>){
        filterList = newItem.toMutableList()
        notifyDataSetChanged()
    }

    fun getData(): List<Item>{
        var pferFlavored = loadFlavoredName(StarPeopleApplication.getAppContext())
        if(pferFlavored.isNotEmpty()){
            pferFlavored.forEach{flav ->
                 filterList.forEach{ list ->
                     if(list.name == flav.name){
                        list.favourite = true
                      }else {
                           list.favourite = false
                    }
                 }
            }
        } else {
            filterList.forEach({list ->
                list.favourite = false
            })
        }
        return filterList
    }


}


