package com.antoniosj.actorstmdb.actordetail.model

import com.antoniosj.actorstmdb.entity.MovieCredit
import com.google.gson.annotations.SerializedName

data class ActorDetailResponse(
    @SerializedName("cast")
    val movieCredits: List<MovieCredit>
)
