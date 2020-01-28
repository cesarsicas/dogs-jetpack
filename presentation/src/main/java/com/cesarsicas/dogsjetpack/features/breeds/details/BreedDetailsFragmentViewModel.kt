package com.cesarsicas.dogsjetpack.features.breeds.details

import androidx.lifecycle.*
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.cesarsicas.dogsjetpack.features.breeds.model.BreedImage
import com.cesarsicas.domain.features.breeds.interactors.GetBreedById
import com.cesarsicas.domain.features.breeds.interactors.GetBreedImages
import kotlinx.coroutines.Dispatchers

internal class BreedDetailsFragmentViewModel(
                private val getBreedById: GetBreedById,
                private val getBreedImages:GetBreedImages): ViewModel() {

    var images: LiveData<List<BreedImage>>?=null


    fun getBreed(breedId:Int): LiveData<Breed> {
        val interactorResult = getBreedById.execute(breedId)

        return Transformations.map(interactorResult) {
                Breed.fromDomainObject(it)
        }

    }


    fun refreshImages(breedId:Int) {
        images = liveData(Dispatchers.IO) {
            val result = getBreedImages.execute(breedId).map { BreedImage.fromDomainObject(it)}
            emit(result)
        }
    }
}



