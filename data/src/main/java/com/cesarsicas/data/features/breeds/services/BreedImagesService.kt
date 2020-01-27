package com.cesarsicas.data.features.breeds.services

import com.cesarsicas.data.features.breeds.model.BreedImage
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BreedImagesService {
    @GET("v1/images/search")
    fun getImages(@Query("format") format: String,
                  @Query("has_breeds") hasBreeds: Boolean,
                  @Query("limit") limit: Int,
                  @Query("breed_id") breedId: Int): Single<List<BreedImage>>

}


