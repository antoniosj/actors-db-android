package com.antoniosj.actorstmdb.repository

import com.antoniosj.actorstmdb.remote.ApiRouterFactory
import com.antoniosj.actorstmdb.actordetail.model.ActorDetailResponse

class MovieCreditsRepository : Repository<ActorDetailResponse> {
    override suspend fun getAll(page: Int): ActorDetailResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getById(id: Int) = ApiRouterFactory.tmdbApi.getMovieCredits(id)
}