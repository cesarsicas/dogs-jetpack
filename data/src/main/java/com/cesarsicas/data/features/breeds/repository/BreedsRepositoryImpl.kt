package com.cesarsicas.data.features.breeds.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.cesarsicas.data.database.DatabaseBuilder
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain
import androidx.lifecycle.Transformations
import com.cesarsicas.data.features.breeds.entities.BreedEntity


class BreedsRepositoryImpl(private val application:Application) : BreedsRepository {

    override fun getBreeds(): LiveData<List<BreedDomain>> {

        val databaseLiveData =  DatabaseBuilder.build(application).breedDao().getAll()

        return  Transformations.map(databaseLiveData, ::convert)

//        return Transformations.map(databaseLiveData) {
//                newData -> newData.map { it.toDomainObject() }
//        }

    }

    private fun convert(breeds: List<BreedEntity>): List<BreedDomain> {
        return breeds.map { it.toDomainObject() }
    }
}