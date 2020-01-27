package com.cesarsicas.dogsjetpack.features.breeds.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.cesarsicas.domain.features.breeds.interactors.GetBreeds

internal class BreedListFragmentViewModel(private val getBreeds: GetBreeds) : ViewModel() {


    fun getBreedsLiveData(): LiveData<List<Breed>> {
        val interactorResult = getBreeds.execute()

        return Transformations.map(interactorResult) {
                newData -> newData.map { Breed.fromDomainObject(it) }
        }

    }
}



