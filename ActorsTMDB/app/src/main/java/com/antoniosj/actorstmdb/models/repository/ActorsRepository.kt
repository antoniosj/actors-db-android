package com.antoniosj.actorstmdb.models.repository

import com.antoniosj.actorstmdb.models.remote.ApiRouterFactory

class ActorsRepository {

    suspend fun getAll() = ApiRouterFactory.tmdbApi.getPopularActors()

}