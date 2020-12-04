package com.example.desafiointegrador3.services

import com.example.desafiointegrador3.utils.Comic
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("characters/1009610/comics")
    suspend fun getComics(
            @Query("ts") ts: String,
            @Query("apikey") apikey: String,
            @Query("hash") hash: String,
            @Query("orderBy") orderBy: String = "-issueNumber",
            @Query("limit") limit: String = "21"
    ): Comic
}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/"

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(urlApiMarvel)
    .build()

val service: Service = retrofit.create(Service::class.java)