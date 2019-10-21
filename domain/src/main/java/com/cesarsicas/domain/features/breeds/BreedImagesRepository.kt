package com.cesarsicas.domain.features.breeds

import com.cesarsicas.domain.features.breeds.model.BreedImageDomain
import io.reactivex.Single


interface BreedImagesRepository {

    fun getImages(breedId:Int): Single<List<BreedImageDomain>>
}