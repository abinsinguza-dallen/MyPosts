package com.ron.myposts

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object API_client{
    var retrofit=Retrofit.Builder()
        .baseUrl( "https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun <T> buildAPI_client(apiInterface:Class<T>):T{
        return retrofit.create(apiInterface)
    }
}