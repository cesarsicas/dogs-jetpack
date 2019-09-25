package com.cesarsicas.data.features.breeds.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Breed (
    @PrimaryKey val id: Int,
    val name:String,
    val temperament:String,
    val height:String,
    val weight:String,
    @ColumnInfo(name ="origin_country") val originCountry:String,
    val thumb:String)