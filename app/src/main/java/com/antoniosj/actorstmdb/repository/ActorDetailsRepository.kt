package com.antoniosj.actorstmdb.repository

import com.antoniosj.actorstmdb.remote.ApiRouterFactory
import com.antoniosj.actorstmdb.actordetail.model.ActorDetailResponse
import com.antoniosj.actorstmdb.remote.TmdbService

    class ActorDetailsRepository(val tmdbService: TmdbService): Repository<ActorDetailResponse> {
    override suspend fun getById(id: Int): ActorDetailResponse =
       // ApiRouterFactory.tmdbApi.getMovieCredits(id)
        tmdbService.getMovieCredits(id)
}

/*
* prover o modulo do retrofit
* se precisar dele passado por parametro, ele vai saber de onde provem
* se precisar instanciar ele, da inject no field.
* testr isso em cima
*
 */