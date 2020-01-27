package com.cesarsicas.dogsjetpack.core

import android.app.Application
import android.content.Context
import com.cesarsicas.data.database.DatabaseBuilder
import com.facebook.stetho.Stetho
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidContext

class DogsJetPackApplication : Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext


        Stetho.initializeWithDefaults(this)

        DatabaseBuilder.build(this)

        /* Setup Koin */
        startKoin {
            androidContext(appContext)
            modules(listOf(appModule, dataModule, domainModule, presentationModule))
        }

    }
}