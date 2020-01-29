package com.cesarsicas.data.features.breeds.services

import com.cesarsicas.data.features.breeds.model.BreedImage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreedImagesService {
    @GET("v1/images/search")
    suspend fun getImages(@Query("format") format: String,
                  @Query("has_breeds") hasBreeds: Boolean,
                  @Query("limit") limit: Int,
                  @Query("breed_id") breedId: Int): Response<List<BreedImage>>

}


