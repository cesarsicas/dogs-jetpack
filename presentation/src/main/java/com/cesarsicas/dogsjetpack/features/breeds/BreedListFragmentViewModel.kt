package com.cesarsicas.dogsjetpack.features.breeds

import android.app.Application
import androidx.lifecycle.*
import com.cesarsicas.data.features.breeds.repository.BreedsRepositoryImpl
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.cesarsicas.domain.features.breeds.interactors.GetBreeds

internal class BreedListFragmentViewModel(val app: Application) : AndroidViewModel(app) {

    //todo inject
    private val getBreeds: GetBreeds = GetBreeds()



    fun getBreedsLiveData(): LiveData<List<Breed>> {
        val interactorResult = getBreeds.execute(BreedsRepositoryImpl(app))

        return Transformations.map(interactorResult) {
                newData -> newData.map { Breed.fromDomainObject(it) }
        }

    }
}



