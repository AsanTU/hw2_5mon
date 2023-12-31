package com.example.hw2_5mon.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    val firstName:String,
    @SerializedName("sname")
    val secondName:String,
    val percentage:String,
    val result:String,
)
//{"fname":"John",
// "sname":"Alice",
// "percentage":"46",
// "result":"Can choose someone better."}