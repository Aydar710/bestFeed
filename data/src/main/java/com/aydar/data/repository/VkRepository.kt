package com.aydar.data.repository

import com.aydar.data.api.VkApi
import com.aydar.data.model.groupWallRemote.GroupWallResponseWrapper
import javax.inject.Inject

class VkRepository @Inject constructor(private val vkApi: VkApi) {

    suspend fun getGroupPosts(): GroupWallResponseWrapper {
        return vkApi.getGroupPosts(
            domain = "mudakoff",
            count = "10"
        )
    }
}