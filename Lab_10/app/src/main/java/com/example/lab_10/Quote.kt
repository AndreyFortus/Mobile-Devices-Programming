package com.example.lab_10

import com.google.gson.annotations.SerializedName

data class Quote (
    val id:Int,
    val quote:String,
    @SerializedName("author")
    val quoteAuthor:String
)