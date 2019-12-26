package com.antoniosj.actorstmdb.remote

import retrofit2.http.GET
import retrofit2.http.Path

// retrofit interface
interface TmdbService {

    @GET("person/popular")
    suspend fun getPopularActors() : ActorResponse

    @GET("person/{person_id}/movie_credits")
    suspend fun getMovieCredits(@Path("person_id") id: Int) : MovieCreditResponse

}