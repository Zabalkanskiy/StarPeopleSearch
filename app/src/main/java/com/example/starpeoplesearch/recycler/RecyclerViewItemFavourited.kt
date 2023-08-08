package com.example.starpeoplesearch.recycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starpeoplesearch.R
import com.example.starpeoplesearch.StarPeopleApplication
import com.example.starpeoplesearch.helper.Item
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class RecyclerViewItemFavourited (var items : List<Item>) : RecyclerView.Adapter<ViewHolderItem>() {
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
           // filterList.get(position).favourite = !filterList.get(position).favourite
            //Нужно вставить логику щелчка нужно сохранить данные или в базе или в sharedPreferences
            if (filterList.get(position).favourite){
                deleteFlavoredName(context = StarPeopleApplication.getAppContext(), item = filterList.get(position))
                val list = loadFlavoredName(StarPeopleApplication.getAppContext())
                updateViewItem(list)


            }//else{
           //     saveFlavoredName(context = StarPeopleApplication.getAppContext(), item = filterList.get(position))
           // }
//            holder.flavoredCheckBox.isChecked = filterList.get(position).favourite
        }
        holder.flavoredCheckBox.isChecked = filterList.get(position).favourite
//        notifyDataSetChanged()

    }

    fun updateViewItem( newItem: List<Item>){
        filterList = newItem.toMutableList()
        notifyDataSetChanged()
    }


}

const val PREFS_NAME = "STARPEOPLE"
const val LISTFAVOURITES = "LISTFAVOURITES"

fun saveFlavoredName(context: Context, item: Item){
    val gson = Gson()
    val itemString = gson.toJson(item)
    //val str = itemString.toString()
    val prefs = context.getSharedPreferences(PREFS_NAME, 0)
    val setString: HashSet<String?> = prefs.getStringSet(LISTFAVOURITES, mutableSetOf()).let {HashSet<String?>(it)}
    setString?.add(itemString)
    context.getSharedPreferences(PREFS_NAME,0).edit().putStringSet(LISTFAVOURITES, setString).apply()

}

fun deleteFlavoredName(context: Context, item: Item){
    val gson = Gson()
    val itemString = gson.toJson(item)
    val prefs = context.getSharedPreferences(PREFS_NAME, 0)
    val setString: HashSet<String?> = prefs.getStringSet(LISTFAVOURITES, mutableSetOf()).let {HashSet<String?>(it)}
    val updateStringSet = setString?.remove(itemString)
    Log.d("DELETE ITEM", updateStringSet.toString())
    context.getSharedPreferences(PREFS_NAME,0).edit().putStringSet(LISTFAVOURITES, setString).apply()


}

fun loadFlavoredName(context: Context): List<Item>{
    val gson = Gson()
    val prefs = context.getSharedPreferences(PREFS_NAME, 0)
    val emtyItem: Item = Item(name = "emppty", information = "not flavored Item")
    val jsonItem = gson.toJson(emtyItem)
    val set: Set<String> = setOf<String>(jsonItem)
    val listItem: MutableList<Item> = mutableListOf()
    val type: Type = object : TypeToken<Item>(){}.type
    val resultSet = prefs.getStringSet(LISTFAVOURITES, set)
    resultSet?.forEach { x ->
        listItem.add(gson.fromJson(x, type))
    }

    return listItem

}
