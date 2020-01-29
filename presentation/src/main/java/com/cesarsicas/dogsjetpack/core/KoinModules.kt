package com.cesarsicas.dogsjetpack.core


import com.cesarsicas.data.features.breeds.repository.BreedsImagesRepositoryImpl
import com.cesarsicas.data.features.breeds.repository.BreedsRepositoryImpl
import com.cesarsicas.data.features.breeds.services.BreedImagesService
import com.cesarsicas.data.retrofit.HeaderInterceptor
import com.cesarsicas.dogsjetpack.BuildConfig
import com.cesarsicas.dogsjetpack.features.breeds.details.BreedDetailsFragmentViewModel
import com.cesarsicas.dogsjetpack.features.breeds.list.BreedListFragmentViewModel
import com.cesarsicas.domain.features.breeds.BreedImagesRepository
import com.cesarsicas.domain.features.breeds.BreedsRepository
import com.cesarsicas.domain.features.breeds.interactors.GetBreedById
import com.cesarsicas.domain.features.breeds.interactors.GetBreedImages
import com.cesarsicas.domain.features.breeds.interactors.GetBreeds
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    factory { HeaderInterceptor() }
    factory { providesOkHttpClient(get()) }
    single { createWebService<BreedImagesService>(get(), BuildConfig.BASE_URL) }

}

val dataModule = module {
    single<BreedsRepository> { BreedsRepositoryImpl(get()) }
    single<BreedImagesRepository> { BreedsImagesRepositoryImpl(get()) }

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

fun providesOkHttpClient(headerInterceptor: HeaderInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .addInterceptor( HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        } )
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient , url: String): T {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(okHttpClient)
        .build()
        .create(T::class.java)
}