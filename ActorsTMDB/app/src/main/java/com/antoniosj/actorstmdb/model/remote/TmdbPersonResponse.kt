package com.antoniosj.actorstmdb.model.remote

import com.antoniosj.actorstmdb.model.entity.TmdbPerson

data class TmdbMovieResponse(
    val results: List<TmdbPerson>
)