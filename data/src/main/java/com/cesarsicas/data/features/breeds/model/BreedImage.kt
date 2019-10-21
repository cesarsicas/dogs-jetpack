package com.cesarsicas.data.features.breeds.model

import com.cesarsicas.domain.features.breeds.model.BreedImageDomain
import com.google.gson.annotations.SerializedName

data class BreedImage (
    @SerializedName("url") val url: String?,
    @SerializedName("width") val width:Int?,
    @SerializedName("height") val height:String?) {

    fun asDomainObject(): BreedImageDomain {
        return BreedImageDomain(
            this.url,
            this.width,
            this.height
        )
    }
}