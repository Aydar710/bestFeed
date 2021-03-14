package com.aydar.data.api

import com.aydar.data.model.groupWallRemote.GroupWallResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface VkApi {

    @GET("wall.get")
    suspend fun getGroupPosts(
        @Query("owner_id") ownerId: String,
        @Query("count") count: String,
        @Query("offset") offset: String = "0",
        @Query("access_token") access_token: String
    ): GroupWallResponseWrapper
}