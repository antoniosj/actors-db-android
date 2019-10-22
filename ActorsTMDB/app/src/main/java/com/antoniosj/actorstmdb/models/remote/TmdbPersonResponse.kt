package com.antoniosj.actorstmdb.models.remote

import com.antoniosj.actorstmdb.models.entity.TmdbPerson

data class TmdbPersonResponse (
    val results: List<TmdbPerson>
)