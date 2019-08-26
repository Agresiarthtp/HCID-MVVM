package com.kotlin.homecreditindonesia.entity

import com.google.gson.annotations.SerializedName

data class ResponseProduct(

    @field:SerializedName("data")
    val data: List<DataItemProduct?>? = null
)