package com.aydar.data.model.groupWallRemote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostSource (

    @SerializedName("type")
    @Expose
    val type: String? = null

)
