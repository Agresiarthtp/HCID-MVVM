package com.kotlin.homecreditindonesia.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InitRetrofit {
    private val BASE_URL = "https://private-a8e48-hcidtest.apiary-mock.com"

    private fun init(): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun instance(): RestApi = init().create(RestApi::class.java)
}