package com.antoniosj.actorstmdb.remote.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.ActorResponse
import com.antoniosj.actorstmdb.remote.ApiRouterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Paging 1/5: Cria uma classe datasource passando o scope pro corountines e o tipo do datasource
// int é para os parametros (de página por exemplo) que no json está como int
// o retorno é a lista pra fazer o bind

class ActorsDataSource(var scope: CoroutineScope): PageKeyedDataSource<Int, Actor>() {

    var api = ApiRouterFactory.tmdbApi

    // vai pegar a primeira página a ser exibida (1 no meu caso) e vai entregar via callback
    // a lista e a próxima página

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Actor>
    ) {
        scope.launch {
            withContext(Dispatchers.IO) {
                var actorResponse = api.getPopularActors(1)
                Log.d("Antonio2", actorResponse.results.toString())
                callback.onResult(actorResponse.results, null, 2)
            }
        }
    }

    // pega a página atual e da + 1
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Actor>) {
        scope.launch {
            withContext(Dispatchers.IO) {
                var actorResponse = api.getPopularActors(params.key)
                Log.d("Antonio3", params.key.toString())
                Log.d("Antonio3", actorResponse.results.toString())
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