package com.antoniosj.actorstmdb.di

import com.antoniosj.actorstmdb.listactors.viewmodel.ListActorsViewModel
import com.antoniosj.actorstmdb.remote.ActorResponse
import com.antoniosj.actorstmdb.repository.ActorsRepository
import com.antoniosj.actorstmdb.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActorsModule {

    @Singleton
    @Provides
    fun provideListActorsViewModel(repository: Repository<ActorResponse>): ListActorsViewModel = ListActorsViewModel(repository)

    @Singleton
    @Provides
    fun provideRepo(): Repository<ActorResponse> = ActorsRepository()
}