package com.geminiboy.newsapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geminiboy.newsapi.model.articel.Article
import com.geminiboy.newsapi.model.articel.ResponseArticles
import com.geminiboy.newsapi.network.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel : ViewModel() {

    lateinit var liveDataArticle : MutableLiveData<List<Article>>

    init {
        liveDataArticle = MutableLiveData()
    }

    fun getDataArticle() : MutableLiveData<List<Article>>{
        return liveDataArticle
    }

    fun callApiArticle(article : String){
        NetworkClient.instance.gellAllArticles(article).enqueue(object : Callback<ResponseArticles>{
            override fun onResponse(
                call: Call<ResponseArticles>,
                response: Response<ResponseArticles>
            ) {

                if (response.isSuccessful){
                    liveDataArticle.postValue(response.body()!!.articles)
                }else{
                    liveDataArticle.postValue(null)
                }


            }

            override fun onFailure(call: Call<ResponseArticles>, t: Throwable) {

                liveDataArticle.postValue(null)

            }

        })

    }
}