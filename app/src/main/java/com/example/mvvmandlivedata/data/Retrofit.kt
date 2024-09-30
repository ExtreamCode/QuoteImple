package com.example.mvvmandlivedata.data

import com.example.mvvmandlivedata.helpers.ApiService
import com.example.mvvmandlivedata.helpers.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object Retrofit {

    private fun getInterceptor() : OkHttpClient.Builder {
        return  OkHttpClient.Builder()
            .addInterceptor()
            .build()
    }

    private fun getRetorfitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.Create())
            .build()
    }

    fun getQuotes() : ApiService {
        return  getRetorfitInstance().create(ApiService::class.java)
    }
}