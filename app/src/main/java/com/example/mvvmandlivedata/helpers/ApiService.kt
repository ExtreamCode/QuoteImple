package com.example.mvvmandlivedata.helpers

import com.example.mvvmandlivedata.models.QuoteList
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("qotd")
    fun getQuoteList(
        /*@Query("page") page : Int*/
    ) : Call<QuoteList>
}