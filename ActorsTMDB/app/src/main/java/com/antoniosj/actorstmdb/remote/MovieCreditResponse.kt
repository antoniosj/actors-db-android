package com.antoniosj.actorstmdb.remote

import com.antoniosj.actorstmdb.entity.MovieCredit
import com.google.gson.annotations.SerializedName

data class MovieCreditResponse(
    @SerializedName("cast")
    val movieCredits: List<MovieCredit>
)
