package com.antoniosj.actorstmdb.models.entity

data class TmdbActor(
    val id: Int,
    val name: String,
    //val profilePath
    val adult: Boolean
)