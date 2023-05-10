package com.geminiboy.newsapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geminiboy.newsapi.model.Source
import com.geminiboy.newsapi.network.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourceViewModel : ViewModel() {

    lateinit var liveDataSource : MutableLiveData<List<Source>?>

    init {
        liveDataSource = MutableLiveData()
    }

    fun getDataSource() : MutableLiveData<List<Source>?>{
        return liveDataSource
    }

    fun callApiSource(category : String){
        NetworkClient.instance.getAllSources(category)
            .enqueue(object :Callback<List<Source>>{
                override fun onResponse(
                    call: Call<List<Source>>,
                    response: Response<List<Source>>
                ) {
                    if (response.isSuccessful){
                        liveDataSource.postValue(response.body())
                    }else{
                        liveDataSource.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<Source>>, t: Throwable) {
                    liveDataSource.value = emptyList()
                }

            })
    }
}