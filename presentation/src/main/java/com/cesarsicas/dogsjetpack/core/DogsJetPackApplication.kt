package com.cesarsicas.dogsjetpack.core

import android.app.Application
import android.content.Context
import com.cesarsicas.data.database.DatabaseBuilder

class DogsJetPackApplication : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        DatabaseBuilder.build(this)



    }
}