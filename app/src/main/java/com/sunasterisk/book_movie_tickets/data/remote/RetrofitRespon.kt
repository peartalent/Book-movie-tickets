package com.dinhtai.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitRespon {
    lateinit var mRetrofit: Retrofit
    constructor(){
        mRetrofit=buildRetrofit()
    }
    private fun buildRetrofit() : Retrofit{
        val url ="https://api.themoviedb.org/3/"
        return  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
    }
    fun getRetrofit() =mRetrofit
    companion object {
        @Volatile
        private var INSTANCE: RetrofitRespon? = null

        fun getInstance() =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: RetrofitRespon().also { INSTANCE = it }
            }
    }
}
