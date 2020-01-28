package com.cesarsicas.data.features.breeds.repository

import com.cesarsicas.data.features.breeds.services.BreedImagesService
import com.cesarsicas.domain.features.breeds.BreedImagesRepository
import com.cesarsicas.domain.features.breeds.model.BreedImageDomain

class BreedsImagesRepositoryImpl(private val service: BreedImagesService) : BreedImagesRepository {

    override suspend fun getImages(breedId:Int): List<BreedImageDomain> {

        return service.getImages("json", true, 10, breedId).map { response ->
                response.asDomainObject()
            }
    }
}