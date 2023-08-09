package com.example.starpeoplesearch.retrofit

import android.database.Observable
import com.example.starpeoplesearch.retrofit.data.SearchPeople
import com.example.starpeoplesearch.retrofit.data.SearchStarShip
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApi {
    @GET("people/")
    suspend fun getPeople(@Query("search") name : String) : SearchPeople

    @GET("starships/")
    suspend fun getStarhips(@Query("search") ship : String) : SearchStarShip

    @GET("starships/")
     fun getStarhipsRx(@Query("search") ship : String) : Observable<SearchStarShip>

    @GET("people/")
     fun getPeopleRx(@Query("search") name : String) : Observable<SearchPeople>
}