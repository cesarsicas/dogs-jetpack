package com.cesarsicas.dogsjetpack.features.breeds.details

import android.app.Application
import androidx.lifecycle.*
import com.cesarsicas.data.features.breeds.repository.BreedsImagesRepositoryImpl
import com.cesarsicas.data.features.breeds.repository.BreedsRepositoryImpl
import com.cesarsicas.dogsjetpack.features.breeds.model.Breed
import com.cesarsicas.dogsjetpack.features.breeds.model.BreedImage
import com.cesarsicas.domain.features.breeds.interactors.GetBreedById
import com.cesarsicas.domain.features.breeds.interactors.GetBreedImages

internal class BreedDetailsFragmentViewModel(val app: Application) : AndroidViewModel(app) {

    //todo inject
    private val getBreed: GetBreedById = GetBreedById()

    private val getBreedImages = GetBreedImages()

    private var liveData: MutableLiveData<List<BreedImage>> = MutableLiveData();


    fun getBreed(breedId:Int): LiveData<Breed> {
        val interactorResult = getBreed.execute(BreedsRepositoryImpl(app), breedId)

        return Transformations.map(interactorResult) {
                Breed.fromDomainObject(it)
        }

    }

    fun getImagesLiveData() = liveData


    fun refreshImages(breedId:Int) {

        val disposable = getBreedImages.execute(BreedsImagesRepositoryImpl(app), breedId)
            .subscribe({ images ->
                liveData.value = images.map { BreedImage.fromDomainObject(it) }

                }) {
            }

        }
}



