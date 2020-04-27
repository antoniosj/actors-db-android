package com.antoniosj.actorstmdb.listactors.model

import com.antoniosj.actorstmdb.entity.Actor

data class ActorResponse (
    val results: List<Actor>
)