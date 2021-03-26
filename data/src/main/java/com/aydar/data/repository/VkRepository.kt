package com.aydar.data.repository

import com.aydar.data.api.VkApi
import com.aydar.data.model.groupWallRemote.GroupWallResponseWrapper
import javax.inject.Inject

class VkRepository @Inject constructor(private val vkApi: VkApi) {

    suspend fun getGroupPosts(domain: String, offset: Int): GroupWallResponseWrapper {
        return vkApi.getGroupPosts(
            domain = domain,
            count = "20",
            offset = offset.toString()
        )
    }
}