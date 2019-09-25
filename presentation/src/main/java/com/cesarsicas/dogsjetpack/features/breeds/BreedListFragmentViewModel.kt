package com.cesarsicas.dogsjetpack.features.breeds

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.cesarsicas.domain.features.breeds.interactors.GetBreeds

internal class BreedListFragmentViewModel : ViewModel(){

        //todo inject
     private val getBreeds: GetBreeds= GetBreeds()

     private var breedsLiveData = MutableLiveData<List<Breed>>()


    fun getBreedsLiveData(): MutableLiveData<List<Breed>> {
        breedsLiveData.value = listOf()
        return breedsLiveData
    }


    fun refreshBreeds(){
        breedsLiveData.value = getBreeds.execute().map { Breed.fromDomainObject(it)}
    }
}