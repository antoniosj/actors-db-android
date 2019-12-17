package com.antoniosj.actorstmdb.entity

import android.os.Parcelable
import com.antoniosj.actorstmdb.Constants
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


class Actor(
    var id: Int,
    var name: String,
    //@SerializedName("profile_path")
    profilePath: String,
    var adult: Boolean
) : Serializable {
    @SerializedName("profile_path")
    val profilePath = profilePath
        get() = Constants.PROFILE_PATH_BASE + field

    //just for debug purpose
    override fun toString(): String = "name: $name profile: $profilePath is Adult? $adult"
}