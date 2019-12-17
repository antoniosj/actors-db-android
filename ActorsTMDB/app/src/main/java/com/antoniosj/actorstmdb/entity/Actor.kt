package com.antoniosj.actorstmdb.entity

import com.antoniosj.actorstmdb.Constants
import com.google.gson.annotations.SerializedName

class Actor(
    var id: Int,
    var name: String,
    //@SerializedName("profile_path")
    profilePath: String,
    var adult: Boolean
) {
    @SerializedName("profile_path")
    val profilePath = profilePath
        get() = Constants.PROFILE_PATH_BASE + field

    //just for debug purpose
    override fun toString(): String = "name: $name profile: $profilePath is Adult? $adult"
}