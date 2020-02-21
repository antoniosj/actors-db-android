package com.antoniosj.actorstmdb.di.components

import com.antoniosj.actorstmdb.actordetail.view.ActorDetailActivity
import com.antoniosj.actorstmdb.di.modules.ActorsModule
import com.antoniosj.actorstmdb.di.modules.AppModule
import com.antoniosj.actorstmdb.di.modules.RepositoryModule
import com.antoniosj.actorstmdb.listactors.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActorsModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(target: MainActivity)
    fun inject(target: ActorDetailActivity)
}