package com.aydar.data.repository

import com.aydar.data.api.VkApi
import javax.inject.Inject

class VkRepository @Inject constructor(private val vkApi: VkApi) {

    suspend fun getGroupPosts(ownerId: Long) {
//        vkApi.getGroupPosts()
    }
}