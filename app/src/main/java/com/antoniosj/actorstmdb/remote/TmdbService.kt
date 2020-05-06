package com.antoniosj.actorstmdb.remote

import com.antoniosj.actorstmdb.actordetail.model.ActorDetailsResponse
import com.antoniosj.actorstmdb.actordetail.model.ActorMovieCreditsResponse
import com.antoniosj.actorstmdb.listactors.model.ActorResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// retrofit interface
interface TmdbService {

    @GET("person/popular")
    suspend fun getPopularActors(@Query("page") page: Int = 1
                                 ) : ActorResponse

    @GET("person/{person_id}/movie_credits")
    suspend fun getMovieCredits(@Path("person_id") id: Int) : ActorMovieCreditsResponse

    //suspend fun de retornar details pra pegar biography no actor details
    @GET("person/{person_id}")
    suspend fun getActorDetails(@Path("person_id") id: Int) : ActorDetailsResponse

}