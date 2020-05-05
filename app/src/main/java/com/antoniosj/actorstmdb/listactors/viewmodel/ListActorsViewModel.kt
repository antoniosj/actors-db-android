package com.antoniosj.actorstmdb.listactors.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.repository.RemoteRepository
import javax.inject.Inject

class ListActorsViewModel @Inject constructor(val repository: RemoteRepository<LiveData<PagedList<Actor>>>)
    : ViewModel() {
    fun initializedPagedListBuilder() = repository.getAll()
}