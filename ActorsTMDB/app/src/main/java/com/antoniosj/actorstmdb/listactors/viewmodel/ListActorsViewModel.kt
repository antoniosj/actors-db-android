package com.antoniosj.actorstmdb.listactors.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.antoniosj.actorstmdb.R
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.paging.ActorsDataSource
import com.antoniosj.actorstmdb.remote.ActorResponse
import com.antoniosj.actorstmdb.repository.ActorsRepository
import com.antoniosj.actorstmdb.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


// paging 3/5: eu não preciso mais dos métodos de buscar no repo, agora faço isso do data source
// ps: Eu poderia passar pro repo, mas por questão de aprendizado, vou deixar assim.
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