package com.cesarsicas.dogsjetpack.features.breeds.details

import android.app.Application
import androidx.lifecycle.*
import com.cesarsicas.data.features.breeds.repository.BreedsRepositoryImpl
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.cesarsicas.domain.features.breeds.interactors.GetBreedById
import com.cesarsicas.domain.features.breeds.interactors.GetBreeds

internal class BreedDetailsFragmentViewModel(val app: Application) : AndroidViewModel(app) {

    //todo inject
    private val getBreed: GetBreedById = GetBreedById()



    fun getBreed(breedId:Int): LiveData<Breed> {
        val interactorResult = getBreed.execute(BreedsRepositoryImpl(app), breedId)

        return Transformations.map(interactorResult) {
                Breed.fromDomainObject(it)
        }

    }
}



