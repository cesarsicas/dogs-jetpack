package com.cesarsicas.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cesarsicas.data.features.breeds.dao.BreedDao
import com.cesarsicas.data.features.breeds.entities.Breed


@Database(entities = [Breed::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun breedDao(): BreedDao
}