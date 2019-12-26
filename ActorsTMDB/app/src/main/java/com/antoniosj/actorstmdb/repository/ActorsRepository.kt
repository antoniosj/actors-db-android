package com.antoniosj.actorstmdb.repository

import com.antoniosj.actorstmdb.entity.Actor
import com.antoniosj.actorstmdb.remote.ApiRouterFactory
import com.antoniosj.actorstmdb.remote.ActorResponse

class ActorsRepository : Repository<ActorResponse> {
    override suspend fun getById(id: Int): ActorResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //return ActorResponse(listOf())
    }

    // As it's using coroutines, need to create a suspend fun
    override suspend fun getAll() = ApiRouterFactory.tmdbApi.getPopularActors()
}