package com.antoniosj.actorstmdb.repository

import com.antoniosj.actorstmdb.remote.ApiRouterFactory
import com.antoniosj.actorstmdb.remote.MovieCreditResponse

class MovieCreditsRepository : Repository<MovieCreditResponse> {
    override suspend fun getAll(): MovieCreditResponse {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getById(id: Int) = ApiRouterFactory.tmdbApi.getMovieCredits(id)
}