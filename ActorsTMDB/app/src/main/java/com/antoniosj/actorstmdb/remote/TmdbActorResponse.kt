package com.antoniosj.actorstmdb.remote

import com.antoniosj.actorstmdb.entity.TmdbActor

// return a list of results which I kind of map to my Entity class
data class TmdbActorResponse (
    val results: List<TmdbActor>
)