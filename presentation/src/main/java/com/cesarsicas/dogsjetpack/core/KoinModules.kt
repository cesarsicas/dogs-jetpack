package com.cesarsicas.dogsjetpack.core


import com.cesarsicas.data.features.breeds.repository.BreedsImagesRepositoryImpl
import com.cesarsicas.data.features.breeds.repository.BreedsRepositoryImpl
import com.cesarsicas.dogsjetpack.features.breeds.details.BreedDetailsFragmentViewModel
import com.cesarsicas.dogsjetpack.features.breeds.list.BreedListFragmentViewModel
import com.cesarsicas.domain.features.breeds.BreedImagesRepository
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.interactors.GetBreedById
import com.cesarsicas.domain.features.breeds.interactors.GetBreedImages
import com.cesarsicas.domain.features.breeds.interactors.GetBreeds
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{

}


val dataModule = module {
    single<BreedsRepository> { BreedsRepositoryImpl(get()) }
    single<BreedImagesRepository> { BreedsImagesRepositoryImpl() }

}

val domainModule = module {
    single { GetBreedImages(get()) }
    single { GetBreedById(get()) }
    single { GetBreeds(get()) }

}

val presentationModule = module {
    viewModel { BreedDetailsFragmentViewModel(get(), get()) }
    viewModel { BreedListFragmentViewModel(get()) }
}

