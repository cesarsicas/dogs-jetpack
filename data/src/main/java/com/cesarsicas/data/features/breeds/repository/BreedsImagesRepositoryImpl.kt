package com.cesarsicas.data.features.breeds.repository

import com.cesarsicas.data.features.breeds.services.BreedImagesService
import com.cesarsicas.domain.features.breeds.BreedImagesRepository
import com.cesarsicas.domain.features.breeds.model.BreedImageDomain

class BreedsImagesRepositoryImpl(private val service: BreedImagesService) : BreedImagesRepository {

    override suspend fun getImages(breedId:Int): List<BreedImageDomain>?{

        return try {
            val response = service.getImages("json", true, 10, breedId)
            if (response.isSuccessful) {
               response.body()?.map { it.asDomainObject() }
            }
            else{
                error(" ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            error(e.message ?: e.toString())
        }

    }
}