package com.cesarsicas.domain.features.breeds.interactors

import androidx.lifecycle.LiveData
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain

class GetBreedById {

    fun execute(repository: BreedsRepository, breedId:Int): LiveData<BreedDomain> {
        return repository.getBreedById(breedId)
    }

}