package com.antoniosj.actorstmdb.repository

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.antoniosj.actorstmdb.entity.Actor
import javax.inject.Inject

class ActorsRepository @Inject constructor(val dataSourceFactory: DataSource.Factory<Int, Actor>, val config: PagedList.Config)
    : RemoteRepository<LiveData<PagedList<Actor>>> {
    override fun getAll(): LiveData<PagedList<Actor>> {
        return LivePagedListBuilder<Int, Actor>(dataSourceFactory, config).build()
    }
}