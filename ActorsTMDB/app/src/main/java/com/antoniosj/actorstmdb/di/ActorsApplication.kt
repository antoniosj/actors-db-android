package com.antoniosj.actorstmdb.di

import android.app.Application

class ActorsApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: ActorsApplication): AppComponent {
        return DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()
    }
}