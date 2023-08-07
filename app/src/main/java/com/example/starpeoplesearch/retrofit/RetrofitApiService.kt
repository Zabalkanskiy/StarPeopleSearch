package com.example.starpeoplesearch.retrofit

import com.example.starpeoplesearch.retrofit.data.People
import com.example.starpeoplesearch.retrofit.data.StarShip
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val STAR_WARS_URL ="https://swapi.dev/api/"
class RetrofitApiService {
    private val starRetrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(STAR_WARS_URL)
        .build()

    fun starWarApi(): StarWarsApi {
       return starRetrofit.create(StarWarsApi::class.java)

    }
  suspend  fun searchPeople( name: String) : List<People>?{
        return withContext(Dispatchers.IO){
            return@withContext starWarApi().getPeople(name).results
        }

    }

   suspend fun searchStarShip(starShip: String) : List<StarShip>?{
       return withContext(Dispatchers.IO){
        return@withContext   starWarApi().getStarhips(starShip).results
       }
    }
}