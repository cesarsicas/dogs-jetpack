package com.cesarsicas.dogsjetpack.core

import android.app.Application
import android.content.Context
import com.cesarsicas.data.database.DatabaseBuilder
import com.facebook.stetho.Stetho

class DogsJetPackApplication : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        Stetho.initializeWithDefaults(this)

        DatabaseBuilder.build(this)

    }
}