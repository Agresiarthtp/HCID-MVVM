package com.kotlin.homecreditindonesia.network

import com.kotlin.homecreditindonesia.entity.ResponseArticle
import com.kotlin.homecreditindonesia.entity.ResponseProduct
import retrofit2.Call
import retrofit2.http.GET

interface RestApi {
    @GET("home")
    fun getDataProduct(): Call<ResponseProduct>

    @GET("home")
    fun getDataArticle(): Call<ResponseArticle>
}