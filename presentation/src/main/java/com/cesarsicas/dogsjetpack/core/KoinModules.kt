package com.cesarsicas.dogsjetpack.core


import com.cesarsicas.data.features.breeds.repository.BreedsRepositoryImpl
import com.cesarsicas.domain.features.breeds.BreedsRepository
import org.koin.dsl.module

val appModule = module{

}


val dataModule = module {
    single<BreedsRepository> { BreedsRepositoryImpl(get()) }

}

val domainModule = module {

}

val presentationModule = module {

}
