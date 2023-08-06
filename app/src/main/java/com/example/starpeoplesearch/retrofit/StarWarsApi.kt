package com.example.starpeoplesearch.retrofit

import com.example.starpeoplesearch.retrofit.data.SearchPeople
import com.example.starpeoplesearch.retrofit.data.SearchStarShip
import retrofit2.http.GET
import retrofit2.http.Path

interface StarWarsApi {
    @GET("people/?search={people}")
    suspend fun getPeople(@Path("people") name : String) : SearchPeople

    @GET("starships/?search={ship}")
    suspend fun getStarhips(@Path("ship") ship : String) : SearchStarShip
}