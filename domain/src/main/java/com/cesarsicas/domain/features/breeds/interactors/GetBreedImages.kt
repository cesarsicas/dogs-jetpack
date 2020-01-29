package com.cesarsicas.domain.features.breeds.interactors

import com.cesarsicas.domain.features.breeds.BreedImagesRepository
import com.cesarsicas.domain.features.breeds.model.BreedImageDomain

class GetBreedImages(private val repository: BreedImagesRepository) {

    suspend fun execute(breedId:Int): List<BreedImageDomain>? = repository.getImages(breedId)

}