package com.antoniosj.actorstmdb.repository

import com.antoniosj.actorstmdb.actordetail.model.ActorDetailsResponse
import com.antoniosj.actorstmdb.actordetail.model.ActorMovieCreditsResponse
import com.antoniosj.actorstmdb.remote.TmdbService

class ActorDetailsRepository(val tmdbService: TmdbService): Repository<Any> {
    override suspend fun getById(id: Int): ActorMovieCreditsResponse =
        tmdbService.getMovieCredits(id)

    override suspend fun getDetailsById(id: Int): ActorDetailsResponse = tmdbService.getActorDetails(id)
}