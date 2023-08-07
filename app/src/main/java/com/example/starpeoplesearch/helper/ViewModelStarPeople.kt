package com.example.starpeoplesearch.helper

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.starpeoplesearch.retrofit.RetrofitApiService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.launch

class ViewModelStarPeople : ViewModel() {

    val itemList = MutableLiveData<List<Item>>()

    @OptIn(ObsoleteCoroutinesApi::class)
    val queryChannel = BroadcastChannel<String>(Channel.CONFLATED)

    private var searchResult = queryChannel.asFlow().filter { it.length > 2 }.debounce(500).mapLatest {

            searchStaarshipPeople(it)
        }

    var openResult = searchResult.asLiveData()


    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    fun sea(str: String){
       var live =  flow{

                emit(str)
                  }.filter { it.length > 2 }.debounce(500).mapLatest {
               val result =  searchStaarshipPeople(it)
                    itemList.postValue(result)
                    result
                }.asLiveData()
        if(live.value!=null) {
            itemList.postValue(live.value)
        }
    }

    fun new(name :String){
        if(name.length>2) {
            searchStaarshipPeople(name)
        }
    }



    var retrofitApi = RetrofitApiService()

    fun searchStaarshipPeople(strSearch : String): List<Item>{
        var result: MutableList<Item> = mutableListOf()
        viewModelScope.launch {

            var peopleResult = retrofitApi.searchPeople(strSearch)

            if (peopleResult!=null){
                peopleResult.forEach{people ->
                    var information: String = """
                        gender
                        ${people.gender}
                        
                        hair_color
                        ${people.hairColor}
                        
                        height 
                        ${people.height}
                        
                        homeworld
                        ${people.homeworld} 
                        
                        mass
                        ${people.mass} 
                        
                        skin_color
                        ${people.skinColor}
                        
                        films
                        ${people.films}
                    """.trimIndent()

                    var item : Item = Item(people.name, information = information)
                    result.add(item)
                }
            }

            retrofitApi.searchStarShip(strSearch)?.forEach { starShip ->
                var information: String = """
                                    MGL
                                    ${starShip.mglt}
                                    
                                   cargo_capacity
                                   ${starShip.cargoCapacity}
                                   
                                   consumables
                                   ${starShip.consumables}
                                   
                                   cost_in_credits
                                   ${starShip.costInCredits}
                                   
                                   created
                                   ${starShip.created}
                                   
                                    model
                                    ${starShip.model}
                                    
                                    manufacturer
                                    ${starShip.manufacturer}
                                    
                                    crew
                                    ${starShip.crew}
                                    
                                    films
                                    ${starShip.films.toString()}
                                    
                                """.trimIndent()
                var item = Item(starShip.name, information = information)
                result.add(item)
            }

            itemList.postValue(result)
        }
        if(result != emptyList<Item>()) {
            itemList.postValue(result)
        }
        return  result
    }
}