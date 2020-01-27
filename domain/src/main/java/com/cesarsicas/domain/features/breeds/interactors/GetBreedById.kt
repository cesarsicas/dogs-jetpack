package com.cesarsicas.domain.features.breeds.interactors

import androidx.lifecycle.LiveData
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain

class GetBreedById(private val repository: BreedsRepository) {

    fun execute( breedId:Int): LiveData<BreedDomain> {
        return repository.getBreedById(breedId)
    }

}