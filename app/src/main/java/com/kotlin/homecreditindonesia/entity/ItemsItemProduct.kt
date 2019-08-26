package com.kotlin.homecreditindonesia.entity

import com.google.gson.annotations.SerializedName

data class ItemsItemProduct(

    @field:SerializedName("product_image")
    val productImage: String? = null,

    @field:SerializedName("link")
    val link: String? = null,

    @field:SerializedName("product_name")
    val productName: String? = null
)