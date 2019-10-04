package com.cesarsicas.data.database

import android.app.Application
import androidx.room.Room

object DatabaseBuilder {
    private const val databaseName = "dogs_jetpack_db"

    fun build(applicationContext:Application): AppDatabase {

        //todo shouldnt allow queries on main thread, just for testing

        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, databaseName).allowMainThreadQueries().build()
    }

}