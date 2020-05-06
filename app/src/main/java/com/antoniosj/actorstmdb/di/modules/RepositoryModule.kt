package com.antoniosj.actorstmdb.di.modules

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.antoniosj.actorstmdb.actordetail.model.ActorMovieCreditsResponse
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.TmdbService
import com.antoniosj.actorstmdb.repository.ActorDetailsRepository
import com.antoniosj.actorstmdb.repository.RemoteRepository
import com.antoniosj.actorstmdb.repository.ActorsRepository
import com.antoniosj.actorstmdb.repository.Repository
import com.antoniosj.actorstmdb.repository.bypage.ActorsDataSourceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideActorsRepository(
        actorsDataSourceFactory: ActorsDataSourceFactory, config: PagedList.Config
    ): RemoteRepository<LiveData<PagedList<Actor>>> = ActorsRepository(actorsDataSourceFactory, config)


    @Singleton
    @Provides
    fun provideActorDetailsRepository(tmdbService: TmdbService) : Repository<Any> = ActorDetailsRepository(tmdbService)
}