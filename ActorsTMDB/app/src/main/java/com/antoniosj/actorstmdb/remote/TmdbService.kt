package com.antoniosj.actorstmdb.remote

import retrofit2.http.GET

// retrofit interface
interface TmdbService {

    @GET("person/popular")
    suspend fun getPopularActors() : TmdbActorResponse

}