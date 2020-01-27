package com.cesarsicas.data.features.breeds.repository

import com.cesarsicas.data.features.breeds.services.BreedImagesService
import com.cesarsicas.domain.features.breeds.BreedImagesRepository
import com.cesarsicas.domain.features.breeds.model.BreedImageDomain
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

 class BreedsImagesRepositoryImpl(private val service: BreedImagesService) : BreedImagesRepository {

    override fun getImages(breedId:Int): Single<List<BreedImageDomain>> {

        return service.getImages("json", true, 10, breedId)
            .flatMap {response ->
                val converted = response.map{ it.asDomainObject()}
                Single.just(converted)
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())

    }
}