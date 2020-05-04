package com.antoniosj.actorstmdb.listactors.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.repository.paging.ActorsDataSource
import com.antoniosj.actorstmdb.repository.ActorsDataSourceRepository
import javax.inject.Inject

class ListActorsViewModel @Inject constructor(val repository: ActorsDataSourceRepository<LiveData<PagedList<Actor>>>)
    : ViewModel() {
    fun initializedPagedListBuilder() = repository.getAll()
}