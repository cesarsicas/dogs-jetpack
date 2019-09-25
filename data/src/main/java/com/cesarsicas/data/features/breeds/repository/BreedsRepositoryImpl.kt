package com.cesarsicas.data.features.breeds.repository

import com.cesarsicas.data.features.breeds.dao.BreedDao
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain

class BreedsRepositoryImpl : BreedsRepository {

   // val dao:BreedDao = BreedDao()

    override fun getBreeds(): List<BreedDomain> {
        //todo
    }
}