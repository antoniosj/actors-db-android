package com.antoniosj.actorstmdb.di.modules

import androidx.paging.PagedList
import com.antoniosj.actorstmdb.remote.TmdbService
import com.antoniosj.actorstmdb.repository.bypage.ActorsDataSource
import com.antoniosj.actorstmdb.repository.bypage.ActorsDataSourceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun providePagedListConfig() = PagedList.Config.Builder()
        .setPageSize(5)
        .setEnablePlaceholders(false)
        .build()

    @Singleton
    @Provides
    fun provideActorsDataSourceFactory(tmdbService: TmdbService) = ActorsDataSourceFactory(tmdbService)

    @Singleton
    @Provides
    fun provideActorsDataSource(tmdbService: TmdbService) = ActorsDataSource(tmdbService)
}