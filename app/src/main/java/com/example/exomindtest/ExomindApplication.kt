package com.example.exomindtest

import android.app.Application
import com.example.exomindtest.injection.appModule
import com.example.exomindtest.injection.domainModule
import com.example.exomindtest.injection.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ExomindApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ExomindApplication)
            modules(
                listOf(
                    appModule,
                    presentationModule,
                    domainModule
                )
            )
        }
    }
}