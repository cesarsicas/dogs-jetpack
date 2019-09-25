package com.cesarsicas.domain.features.breeds

import com.cesarsicas.domain.features.breeds.model.BreedDomain

interface BreedsRepository {
    fun getBreeds():List<BreedDomain>
}