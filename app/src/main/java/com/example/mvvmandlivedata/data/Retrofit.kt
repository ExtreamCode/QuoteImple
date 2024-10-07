package com.example.mvvmandlivedata.data

import com.example.mvvmandlivedata.R
import com.example.mvvmandlivedata.helpers.ApiService
import com.example.mvvmandlivedata.helpers.Constants
import com.example.mvvmandlivedata.models.QuoteList
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Objects

object Retrofit {

    private val gson = GsonBuilder()
        .setLenient()
        .create()

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply { level = HttpLoggingInterceptor.Level.BODY }


    private fun getInterceptor() : OkHttpClient {
        return  OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    private fun getRetorfitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://favqs.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getInterceptor())
            .build()
    }

    private fun getQuotes() : ApiService {
        return  getRetorfitInstance().create(ApiService::class.java)
    }

    fun executeApi() {
        CoroutineScope(Dispatchers.IO).launch {
            getQuotes().getQuoteList().execute()
        }
    }

    private fun getString(value : Int) : String {
        return getString(value)
    }
}