package com.example.starpeoplesearch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starpeoplesearch.helper.Item
import com.example.starpeoplesearch.helper.ViewModelStarPeople
import com.example.starpeoplesearch.recycler.RecyclerViewItem
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var flavoredActivityButton: Button
    lateinit var searchEditText: EditText
    lateinit var recyclerViewItem: RecyclerView
    lateinit var viewModelStarPeople: ViewModelStarPeople
    lateinit var welcomeTextView: TextView

    val empty = listOf<Item>()
    val recyclerItem = RecyclerViewItem(empty)
    @OptIn(ObsoleteCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       //add viewModel
         viewModelStarPeople = ViewModelProvider(this).get(ViewModelStarPeople::class.java)


        flavoredActivityButton = findViewById(R.id.main_activity_favorite_button)
        searchEditText = findViewById(R.id.main_activity_search)
        recyclerViewItem = findViewById(R.id.main_activity_recycler_people)
        welcomeTextView = findViewById(R.id.main_activity_welcome_text_view)
        recyclerViewItem.visibility = View.GONE

        //start FlavoredActivity
        flavoredActivityButton.setOnClickListener{
            view->
            val intent = Intent(applicationContext, FlavoredActivity::class.java)
            startActivity(intent)
        }

        searchEditText.doAfterTextChanged {
            lifecycleScope.launch {
              //  viewModelStarPeople.sea(it.toString())
                viewModelStarPeople.new(it.toString())
            }
        }
        recyclerViewItem.layoutManager = LinearLayoutManager(applicationContext)
        //нужно загрузить list<Item>

        recyclerViewItem.adapter = recyclerItem




        viewModelStarPeople.itemList.observe(this, {
            if(it.isNotEmpty()) {
                recyclerItem.updateViewItem(it)
                welcomeTextView.visibility = View.GONE
                recyclerViewItem.visibility = View.VISIBLE

            }else{
                welcomeTextView.visibility = View.VISIBLE
                recyclerViewItem.visibility = View.GONE
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val data = recyclerItem.getData()
        recyclerItem.updateViewItem(data)
        //recyclerViewItem.adapter?.notifyDataSetChanged()
    }
}