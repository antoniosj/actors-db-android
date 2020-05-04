package com.antoniosj.actorstmdb.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.repository.paging.ActorsDataSource
import kotlinx.coroutines.CoroutineScope

class ActorsRepository : ActorsDataSourceRepository<LiveData<PagedList<Actor>>> {

    override fun getAll(): LiveData<PagedList<Actor>> {
        val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setEnablePlaceholders(false)
            .build()

        val dataSourceFactory = object : DataSource.Factory<Int, Actor>() {
            override fun create(): DataSource<Int, Actor> {
                return ActorsDataSource()
            }
        }
        return LivePagedListBuilder<Int, Actor>(dataSourceFactory, config).build()
    }
}