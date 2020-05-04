package com.antoniosj.actorstmdb.di.modules

import com.antoniosj.actorstmdb.actordetail.model.ActorDetailResponse
import com.antoniosj.actorstmdb.remote.TmdbService
import com.antoniosj.actorstmdb.repository.ActorDetailsRepository
import com.antoniosj.actorstmdb.repository.ActorsRepository
import com.antoniosj.actorstmdb.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideActorDetailsRepository(tmdbService: TmdbService) : Repository<ActorDetailResponse> = ActorDetailsRepository(tmdbService)

//    @Singleton
//    @Provides
//    fun provideActorsRepository() = ActorsRepository()
}