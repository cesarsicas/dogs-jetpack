package com.cesarsicas.data.database

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors

object DatabaseBuilder {
    private const val databaseName = "dogs_jetpack_db"

    fun build(applicationContext: Application): AppDatabase {

        //todo shouldnt allow queries on main thread, just for testing

        return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            databaseName
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(@NonNull db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Executors.newSingleThreadScheduledExecutor().execute(object : Runnable {
                        override fun run() {
                            // insert data using DAO
                            //todo include code to populate database
                        }
                    })
                }
            })
            .allowMainThreadQueries().build()

    }

}
