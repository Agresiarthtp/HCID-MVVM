package com.kotlin.homecreditindonesia.entity

import com.google.gson.annotations.SerializedName

data class ItemsItemArticle(

    @field:SerializedName("article_image")
    val articleImage: String? = null,

    @field:SerializedName("article_title")
    val articleTitle: String? = null,

    @field:SerializedName("link")
    val link: String? = null
)