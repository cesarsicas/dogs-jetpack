package com.cesarsicas.data.features.breeds.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cesarsicas.domain.features.breeds.model.BreedDomain

@Entity
data class Breed (
    @PrimaryKey val id: Int,
    val name:String,
    val temperament:String,
    val height:String,
    val weight:String,
    @ColumnInfo(name ="origin_country") val originCountry:String,
    val thumb:String){


    fun toDomainObject(): BreedDomain {
        return BreedDomain(this.id, this.name, this.temperament, this.height, this.weight, this.originCountry, this.thumb)
    }

}