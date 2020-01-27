package com.cesarsicas.domain.features.breeds.interactors

import androidx.lifecycle.LiveData
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain

class GetBreeds(private val repository: BreedsRepository) {

    fun execute(): LiveData<List<BreedDomain>> {
        return repository.getBreeds()
    }

}