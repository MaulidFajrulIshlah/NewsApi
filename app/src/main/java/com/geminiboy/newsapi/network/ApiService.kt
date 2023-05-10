package com.geminiboy.newsapi.network

import com.geminiboy.newsapi.model.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category : String,
        @Query("apiKey") apiKey : String = "714300b24b154d22bf7a8929b8a92eee"
    ): Call<List<Source>>
}