package com.antoniosj.actorstmdb.di

import com.antoniosj.actorstmdb.listactors.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ActorsModule::class])
interface AppComponent {

    fun inject(target: MainActivity)
}