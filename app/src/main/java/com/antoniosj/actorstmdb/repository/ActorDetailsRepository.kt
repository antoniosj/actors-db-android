package com.antoniosj.actorstmdb.repository

import com.antoniosj.actorstmdb.actordetail.model.ActorDetailResponse
import com.antoniosj.actorstmdb.remote.TmdbService

class ActorDetailsRepository(val tmdbService: TmdbService): Repository<ActorDetailResponse> {
    override suspend fun getById(id: Int): ActorDetailResponse =
        tmdbService.getMovieCredits(id)
}