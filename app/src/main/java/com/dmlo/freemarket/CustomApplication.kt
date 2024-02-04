package com.dmlo.freemarket

import android.app.Application
import com.dmlo.freemarket.data.di.dataModule
import com.dmlo.freemarket.repository.di.repositoryModule
import com.dmlo.freemarket.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@CustomApplication)
            modules(
                dataModule,
                repositoryModule,
                uiModule
            )
        }
    }
}