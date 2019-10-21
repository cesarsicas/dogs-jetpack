package com.cesarsicas.data.features.breeds.services

import com.cesarsicas.data.features.breeds.model.BreedImage
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

internal interface BreedImagesService {
    //@GET("v1/images/search?format=json&has_breeds=true&limit=10&breed_id=1")

    @GET("v1/images/search")
    fun getImages(@Query("format") format: String,
                  @Query("has_breeds") hasBreeds: Boolean,
                  @Query("limit") limit: Int,
                  @Query("breed_id") breedId: Int): Single<List<BreedImage>>

}


