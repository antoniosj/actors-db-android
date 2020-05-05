package com.antoniosj.actorstmdb.repository.bypage

import androidx.paging.PageKeyedDataSource
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.TmdbService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ActorsDataSource @Inject constructor(val tmdbService: TmdbService): PageKeyedDataSource<Int, Actor>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Actor>
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            var actorResponse = tmdbService.getPopularActors(1)
            callback.onResult(actorResponse.results, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Actor>) {
        CoroutineScope(Dispatchers.IO).launch {
            var actorResponse = tmdbService.getPopularActors(params.key)
            callback.onResult(actorResponse.results, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Actor>) {
        CoroutineScope(Dispatchers.IO).launch {
            var actorResponse = tmdbService.getPopularActors(params.key)
            callback.onResult(actorResponse.results, params.key - 1)
        }
    }

}