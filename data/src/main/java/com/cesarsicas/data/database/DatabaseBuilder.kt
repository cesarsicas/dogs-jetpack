package com.cesarsicas.data.database

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.cesarsicas.data.features.breeds.entities.BreedEntity
import java.io.IOException
import java.nio.charset.Charset
import java.util.concurrent.Executors
import com.cesarsicas.data.features.breeds.model.BreedModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception


object DatabaseBuilder {
    private const val databaseName = "dogs_jetpack_db"
    private var INSTANCE: AppDatabase? = null


    fun build(applicationContext: Application): AppDatabase {

        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                databaseName
            )
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadScheduledExecutor().execute {
                            val json = loadJSONFromAsset(applicationContext)

                            if (json != null) {
                                val list = convertJsonToObject(json)

                                val convertedList = list?.map {

                                    BreedEntity(
                                        id = 0,
                                        name = it.name,
                                        temperament = it.temperament,
                                        height = it.height,
                                        weight = it.weight,
                                        originCountry = it.originCountry,
                                        thumb = it.thumb
                                    )

                                }

                                build(applicationContext).breedDao()
                                    .insertFromList(convertedList!!)

                            }


                        }
                    }
                })
                .build()
        }

        return INSTANCE!!
    }

    private fun loadJSONFromAsset(applicationContext: Application): String? {
        var json: String?
        try {

            val inputStream = applicationContext.assets.open(databaseName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            json = String(buffer, Charset.forName("utf-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }


    private fun convertJsonToObject(json: String): List<BreedModel>? {

        val listType = object : TypeToken<ArrayList<BreedModel>>() {}.type

        return try {
            val list: List<BreedModel> = Gson().fromJson(json, listType)
            list

        } catch (e: Exception) {
            null
        }


    }
}

