package com.cesarsicas.data.features.breeds.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.cesarsicas.data.database.DatabaseBuilder
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain
import androidx.lifecycle.Transformations
import com.cesarsicas.data.features.breeds.entities.BreedEntity


class BreedsRepositoryImpl(private val applicationContext: Application) : BreedsRepository {
    override fun getBreeds(): LiveData<List<BreedDomain>> {

        val databaseLiveData =  DatabaseBuilder.build(applicationContext).breedDao().getAll()

        return Transformations.map(databaseLiveData) {
                breeds -> breeds.map { it.toDomainObject() }
        }
    }

    override fun getBreedById(breedId: Int): LiveData<BreedDomain> {
        val liveData =  DatabaseBuilder.build(applicationContext).breedDao().getById(breedId)

        return Transformations.map(liveData) {
                it.toDomainObject()
        }
    }
}