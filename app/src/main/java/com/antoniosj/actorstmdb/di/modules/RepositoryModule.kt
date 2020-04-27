package com.antoniosj.actorstmdb.di.modules

import com.antoniosj.actorstmdb.actordetail.model.ActorDetailResponse
import com.antoniosj.actorstmdb.repository.ActorsRepository
import com.antoniosj.actorstmdb.repository.MovieCreditsRepository
import com.antoniosj.actorstmdb.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieCreditsRepository() : Repository<ActorDetailResponse> = MovieCreditsRepository()

    @Singleton
    @Provides
    fun provideActorsRepository() = ActorsRepository()
}