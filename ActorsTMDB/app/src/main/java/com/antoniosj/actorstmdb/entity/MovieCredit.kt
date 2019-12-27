package com.antoniosj.actorstmdb.entity

import com.antoniosj.actorstmdb.Constants
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MovieCredit(
    @SerializedName("vote_average")
    var voteAverage: Float,
    var title: String,
    var character: String,
    var overview: String,
    posterPath: String
) : Serializable {
    @SerializedName("poster_path")
    val posterPath = posterPath
        get() = Constants.IMAGE_PATH_BASE + field
}
