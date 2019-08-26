package com.kotlin.homecreditindonesia.entity

import com.google.gson.annotations.SerializedName

data class DataItemProduct(

    @field:SerializedName("section")
    val section: String? = null,

    @field:SerializedName("items")
    val items: List<ItemsItemProduct?>? = null
)