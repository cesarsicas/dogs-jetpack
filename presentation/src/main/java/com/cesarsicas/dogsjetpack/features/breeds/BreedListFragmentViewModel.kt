package com.cesarsicas.dogsjetpack.features.breeds

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cesarsicas.data.features.breeds.repository.BreedsRepositoryImpl
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.cesarsicas.domain.features.breeds.interactors.GetBreeds

internal class BreedListFragmentViewModel(val app: Application) : AndroidViewModel(app) {

        //todo inject
     private val getBreeds: GetBreeds= GetBreeds()

     private var breedsLiveData = MutableLiveData<List<Breed>>()


    fun getBreedsLiveData(): MutableLiveData<List<Breed>> {
        breedsLiveData.value = listOf()
        return breedsLiveData
    }


    fun refreshBreeds(){
        val result = getBreeds.execute(BreedsRepositoryImpl(app)).map { Breed.fromDomainObject(it)}

        breedsLiveData.value = result
    }
}