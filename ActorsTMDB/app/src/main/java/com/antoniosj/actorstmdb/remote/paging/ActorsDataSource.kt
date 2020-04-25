package com.antoniosj.actorstmdb.remote.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.ApiRouterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActorsDataSource(var scope: CoroutineScope): PageKeyedDataSource<Int, Actor>() {

    var api = ApiRouterFactory.tmdbApi

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Actor>
    ) {
        scope.launch {
            withContext(Dispatchers.IO) {
                var actorResponse = api.getPopularActors(1)
                callback.onResult(actorResponse.results, null, 2)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Actor>) {
        scope.launch {
            withContext(Dispatchers.IO) {
                var actorResponse = api.getPopularActors(params.key)
                callback.onResult(actorResponse.results, params.key + 1)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Actor>) {
        scope.launch {
            withContext(Dispatchers.IO) {
                var actorResponse = api.getPopularActors(params.key)
                callback.onResult(actorResponse.results, params.key - 1)
            }
        }
    }

}