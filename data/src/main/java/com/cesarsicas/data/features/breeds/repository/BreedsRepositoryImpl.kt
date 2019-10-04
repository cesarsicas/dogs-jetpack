package com.cesarsicas.data.features.breeds.repository

import android.app.Application
import com.cesarsicas.data.database.DatabaseBuilder
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain

class BreedsRepositoryImpl(val application:Application) : BreedsRepository {

    override fun getBreeds(): List<BreedDomain> {
        return DatabaseBuilder.build(application).breedDao().getAll().map { it.toDomainObject() }
    }

}