package com.example.starpeoplesearch.helper

import com.google.gson.annotations.SerializedName

data class Item ( @SerializedName("name") val name : String,
                  @SerializedName("information") val information: String,
                  @SerializedName("favourite") var favourite : Boolean = false)