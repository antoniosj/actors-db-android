package com.antoniosj.actorstmdb.di.components

import com.antoniosj.actorstmdb.actordetail.view.ActorDetailActivity
import com.antoniosj.actorstmdb.di.modules.*
import com.antoniosj.actorstmdb.listactors.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActorsModule::class, RepositoryModule::class, DataSourceModule::class, NetworkModule::class])
interface AppComponent {

    fun inject(target: MainActivity)
    fun inject(target: ActorDetailActivity)
}