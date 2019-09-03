package com.kotlin.homecreditindonesia.network

import com.kotlin.homecreditindonesia.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InitRetrofit {

    private fun init(): Retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun instance(): RestApi = init().create(RestApi::class.java)
}