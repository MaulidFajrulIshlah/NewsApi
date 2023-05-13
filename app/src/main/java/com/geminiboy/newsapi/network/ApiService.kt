package com.geminiboy.newsapi.network

import com.geminiboy.newsapi.model.articel.ResponseArticles
import com.geminiboy.newsapi.model.source.ResponseDataSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category : String,
        @Query("apiKey") apiKey : String = "714300b24b154d22bf7a8929b8a92eee"
    ) : Call<ResponseDataSource>

    @GET("top-headlines")
    fun gellAllArticles(
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String = "714300b24b154d22bf7a8929b8a92eee"
    ) : Call<ResponseArticles>
}