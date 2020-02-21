package com.antoniosj.actorstmdb.di.modules

import com.antoniosj.actorstmdb.remote.ActorResponse
import com.antoniosj.actorstmdb.remote.MovieCreditResponse
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
    fun provideMovieCreditsRepository() : Repository<MovieCreditResponse> = MovieCreditsRepository()

    @Singleton
    @Provides
    fun provideActorsRepository(): Repository<ActorResponse> = ActorsRepository()
}