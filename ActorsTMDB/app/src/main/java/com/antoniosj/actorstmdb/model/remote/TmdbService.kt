package com.antoniosj.actorstmdb.model.remote

import retrofit2.Response
import retrofit2.http.GET

interface TmdbService {

    @GET("person/popular")
    suspend fun getPopularPeople() : Response<TmdbMovieResponse>

}