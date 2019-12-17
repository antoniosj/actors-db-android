package com.antoniosj.actorstmdb.remote

import com.antoniosj.actorstmdb.entity.Actor

// return a list of results which I kind of map to my Entity class
data class ActorResponse (
    val results: List<Actor>
)