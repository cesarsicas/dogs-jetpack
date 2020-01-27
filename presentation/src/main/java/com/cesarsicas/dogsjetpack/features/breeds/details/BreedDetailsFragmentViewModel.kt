package com.cesarsicas.dogsjetpack.features.breeds.details

import androidx.lifecycle.*
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.cesarsicas.dogsjetpack.features.breeds.model.BreedImage
import com.cesarsicas.domain.features.breeds.interactors.GetBreedById
import com.cesarsicas.domain.features.breeds.interactors.GetBreedImages

internal class BreedDetailsFragmentViewModel(
                private val getBreedById: GetBreedById,
                private val getBreedImages:GetBreedImages): ViewModel() {

    private var liveData: MutableLiveData<List<BreedImage>> = MutableLiveData()


    fun getBreed(breedId:Int): LiveData<Breed> {
        val interactorResult = getBreedById.execute(breedId)

        return Transformations.map(interactorResult) {
                Breed.fromDomainObject(it)
        }

    }

    fun getImagesLiveData() = liveData


    fun refreshImages(breedId:Int) {

        val disposable = getBreedImages.execute(breedId)
            .subscribe({ images ->
                liveData.value = images.map { BreedImage.fromDomainObject(it) }

                }) {
            }
        }
}



