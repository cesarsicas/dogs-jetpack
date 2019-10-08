package com.cesarsicas.data.features.breeds.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.cesarsicas.data.database.DatabaseBuilder
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.model.BreedDomain
import androidx.lifecycle.Transformations



class BreedsRepositoryImpl(private val application:Application) : BreedsRepository {

    override fun getBreeds(): LiveData<List<BreedDomain>> {

        val databaseLiveData =  DatabaseBuilder.build(application).breedDao().getAll()

        return Transformations.map(databaseLiveData) {
                newData -> newData.map { it.toDomainObject() }

        }


//        val mediator  = MediatorLiveData<List<BreedDomain>>()
//
//        val databaseResult = DatabaseBuilder.build(application).breedDao().getAll()
//
//        mediator.addSource(databaseResult) { result: List<BreedEntity>? ->
//            result?.map { it.toDomainObject() }
//        }
//
//        return mediator
    }

}