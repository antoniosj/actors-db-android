package com.antoniosj.actorstmdb.repository.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.ApiRouterFactory
import com.antoniosj.actorstmdb.remote.TmdbService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

//TODO Injetar ActorsDataSource pra poder injetar o tmdbservice aqui
class ActorsDataSource: PageKeyedDataSource<Int, Actor>() {

    var api = ApiRouterFactory.tmdbApi

   // @Inject lateinit var api: TmdbService

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Actor>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            var actorResponse = api.getPopularActors(1)
            callback.onResult(actorResponse.results, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Actor>) {
        CoroutineScope(Dispatchers.IO).launch {
            var actorResponse = api.getPopularActors(params.key)
            callback.onResult(actorResponse.results, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Actor>) {
        CoroutineScope(Dispatchers.IO).launch {
            var actorResponse = api.getPopularActors(params.key)
            callback.onResult(actorResponse.results, params.key - 1)
        }
    }

}