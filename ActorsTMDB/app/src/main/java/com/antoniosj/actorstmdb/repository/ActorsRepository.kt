package com.antoniosj.actorstmdb.repository

import com.antoniosj.actorstmdb.remote.ApiRouterFactory
import com.antoniosj.actorstmdb.remote.TmdbActorResponse

class ActorsRepository : Repository<TmdbActorResponse> {

    // As it's using coroutines, need to create a suspend fun
    override suspend fun getAll() = ApiRouterFactory.tmdbApi.getPopularActors()
}