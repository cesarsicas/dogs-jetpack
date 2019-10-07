package com.cesarsicas.data.features.breeds.model

import com.google.gson.annotations.SerializedName

data class BreedModel (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name:String,
    @SerializedName("temperament") val temperament:String,
    @SerializedName("height_metric") val height:String,
    @SerializedName("weight_metric")  val weight:String,
    @SerializedName("origin") val originCountry:String,
    @SerializedName("thumb")val thumb:String)