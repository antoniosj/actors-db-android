package com.antoniosj.actorstmdb.di.modules

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.repository.ActorsDataSourceRepository
import com.antoniosj.actorstmdb.repository.ActorsRepository
import com.antoniosj.actorstmdb.repository.Repository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideActorsRepository(): ActorsDataSourceRepository<LiveData<PagedList<Actor>>> = ActorsRepository()
}