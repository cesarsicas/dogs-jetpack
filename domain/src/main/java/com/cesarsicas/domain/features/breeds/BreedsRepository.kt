package com.cesarsicas.domain.features.breeds

import androidx.lifecycle.LiveData
import com.cesarsicas.domain.features.breeds.model.BreedDomain


interface BreedsRepository {

    fun getBreeds(): LiveData<List<BreedDomain>>
}