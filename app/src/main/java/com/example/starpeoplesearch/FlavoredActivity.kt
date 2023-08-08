package com.example.starpeoplesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starpeoplesearch.helper.Item
import com.example.starpeoplesearch.recycler.RecyclerViewItem
import com.example.starpeoplesearch.recycler.RecyclerViewItemFavourited
import com.example.starpeoplesearch.recycler.loadFlavoredName

class FlavoredActivity : AppCompatActivity() {
    lateinit var flavoredRecyclerViewItem: RecyclerViewItemFavourited
    lateinit var recyclerViewFlavored: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flavored)
        recyclerViewFlavored = findViewById(R.id.recycler_flavored_item)
         val items: List<Item> =   loadFlavoredName(StarPeopleApplication.getAppContext())

        flavoredRecyclerViewItem = RecyclerViewItemFavourited(items)
        recyclerViewFlavored.adapter = flavoredRecyclerViewItem
        recyclerViewFlavored.layoutManager = LinearLayoutManager(applicationContext)

    }
}