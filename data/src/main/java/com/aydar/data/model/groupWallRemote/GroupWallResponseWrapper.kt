package com.aydar.data.model.groupWallRemote

import com.aydar.data.model.groupWallRemote.GroupWallResponse
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GroupWallResponseWrapper (

    @SerializedName("response")
    @Expose
    val response: GroupWallResponse? = null

)
