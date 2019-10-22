package com.antoniosj.actorstmdb.models.repository

import com.antoniosj.actorstmdb.models.remote.ApiRouterFactory

class PersonRepository {

    suspend fun getPeople() = ApiRouterFactory.tmdbApi.getPopularPeople()

}