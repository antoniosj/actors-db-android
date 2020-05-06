package com.antoniosj.actorstmdb.actordetail.model

import com.google.gson.annotations.SerializedName

data class ActorDetailsResponse(var biography: String = "",
                                @SerializedName("place_of_birth")
                                var placeOfBirth: String = "")