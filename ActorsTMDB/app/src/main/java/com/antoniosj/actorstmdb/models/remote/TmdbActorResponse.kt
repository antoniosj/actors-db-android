package com.antoniosj.actorstmdb.models.remote

import com.antoniosj.actorstmdb.models.entity.TmdbActor

data class TmdbActorResponse (
    val results: List<TmdbActor>
)