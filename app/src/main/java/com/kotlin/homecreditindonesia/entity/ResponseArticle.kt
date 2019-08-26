package com.kotlin.homecreditindonesia.entity

import com.google.gson.annotations.SerializedName

data class ResponseArticle(

    @field:SerializedName("data")
    val data: List<DataItemArticle?>? = null
)