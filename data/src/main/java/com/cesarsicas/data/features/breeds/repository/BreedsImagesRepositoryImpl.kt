package com.cesarsicas.data.features.breeds.repository

import android.app.Application
import com.cesarsicas.data.features.breeds.services.BreedImagesService
import com.cesarsicas.domain.features.breeds.BreedImagesRepository
import com.cesarsicas.domain.features.breeds.model.BreedImageDomain
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class BreedsImagesRepositoryImpl : BreedImagesRepository {
    val baseUrl = "https://api.thedogapi.com/"
    val token = "0d3d9ff9-9e32-4459-b7db-b5d6516ea844"

    override fun getImages(breedId:Int): Single<List<BreedImageDomain>> {

        //todo refactor this
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val headerInterceptor = Interceptor { chain ->
            var request: okhttp3.Request = chain.request()

            request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", token)
                .build()

            chain.proceed(request)
        }


        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(loggingInterceptor)
        httpClient.addInterceptor(headerInterceptor)


        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()




        val service = retrofit.create(BreedImagesService::class.java)

        return service.getImages("json", true, 10, breedId)
            .flatMap {response ->
                val converted = response.map{ it.asDomainObject()}
                Single.just(converted)
            }
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())

    }
}