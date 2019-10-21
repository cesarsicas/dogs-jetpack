package com.cesarsicas.domain.features.breeds.interactors

import com.cesarsicas.domain.features.breeds.BreedImagesRepository
import com.cesarsicas.domain.features.breeds.model.BreedImageDomain
import io.reactivex.Single

class GetBreedImages {

    fun execute(repository: BreedImagesRepository, breedId:Int): Single<List<BreedImageDomain>> {
        return repository.getImages(breedId)
    }

}