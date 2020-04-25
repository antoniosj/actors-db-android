package com.antoniosj.actorstmdb.listactors.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.paging.ActorsDataSource
import javax.inject.Inject

class ListActorsViewModel @Inject constructor()
    : ViewModel() {

    fun initializedPagedListBuilder():
            LiveData<PagedList<Actor>> {

        val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setEnablePlaceholders(false)
            .build()

        val dataSourceFactory = object : DataSource.Factory<Int, Actor>() {
            override fun create(): DataSource<Int, Actor> {
                return ActorsDataSource(viewModelScope)
            }
        }
        return LivePagedListBuilder<Int, Actor>(dataSourceFactory, config).build()
    }
}