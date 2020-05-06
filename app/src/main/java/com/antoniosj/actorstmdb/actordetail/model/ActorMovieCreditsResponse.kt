package com.antoniosj.actorstmdb.actordetail.model

import com.antoniosj.actorstmdb.entity.MovieCredit
import com.google.gson.annotations.SerializedName

data class ActorMovieCreditsResponse(
    @SerializedName("cast")
    val movieCredits: List<MovieCredit>
)
