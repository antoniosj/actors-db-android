package com.antoniosj.actorstmdb

import android.app.Application
import com.antoniosj.actorstmdb.di.components.AppComponent
import com.antoniosj.actorstmdb.di.components.DaggerAppComponent
import com.antoniosj.actorstmdb.di.modules.AppModule

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