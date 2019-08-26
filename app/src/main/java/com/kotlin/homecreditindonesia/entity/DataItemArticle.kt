package com.kotlin.homecreditindonesia.entity

import com.google.gson.annotations.SerializedName

data class DataItemArticle(

    @field:SerializedName("section_title")
    val sectionTitle: String? = null,

    @field:SerializedName("section")
    val section: String? = null,

    @field:SerializedName("items")
    val items: List<ItemsItemArticle?>? = null
)