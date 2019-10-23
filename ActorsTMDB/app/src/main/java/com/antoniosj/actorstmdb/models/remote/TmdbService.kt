package com.antoniosj.actorstmdb.models.remote

import retrofit2.http.GET

interface TmdbService {

    @GET("person/popular")
    suspend fun getPopularPeople() : TmdbPersonResponse

}