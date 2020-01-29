package com.cesarsicas.domain.features.breeds

import com.cesarsicas.domain.features.breeds.model.BreedImageDomain


interface BreedImagesRepository {

    suspend fun getImages(breedId:Int): List<BreedImageDomain>?
}