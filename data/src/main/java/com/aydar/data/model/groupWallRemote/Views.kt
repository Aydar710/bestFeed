package com.aydar.data.model.groupWallRemote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Views(

    @SerializedName("count")
    @Expose
    val count: Int? = null

)
