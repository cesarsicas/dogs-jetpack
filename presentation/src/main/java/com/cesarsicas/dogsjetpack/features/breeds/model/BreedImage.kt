package com.cesarsicas.dogsjetpack.features.breeds.model

import com.cesarsicas.domain.features.breeds.model.BreedImageDomain

internal data class BreedImage(val url: String?, val height: String?, val width: Int?) {

        companion object {
            fun fromDomainObject(domainObject: BreedImageDomain): BreedImage {
                return BreedImage(domainObject.url, domainObject.height, domainObject.width)
            }
        }

}

