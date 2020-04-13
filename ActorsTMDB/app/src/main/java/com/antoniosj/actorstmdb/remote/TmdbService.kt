package com.antoniosj.actorstmdb.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// retrofit interface
interface TmdbService {

    @GET("person/popular")
    suspend fun getPopularActors(@Query("page") page: Int = 1
                                 ) : ActorResponse

    @GET("person/{person_id}/movie_credits")
    suspend fun getMovieCredits(@Path("person_id") id: Int) : MovieCreditResponse

}