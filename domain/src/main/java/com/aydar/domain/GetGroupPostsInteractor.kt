package com.aydar.domain

import com.aydar.data.model.groupWallRemote.Item
import com.aydar.data.repository.VkRepository
import javax.inject.Inject

class GetGroupPostsInteractor @Inject constructor(private val vkRepository: VkRepository) {

    suspend fun getGroupPosts(): List<Item>? {
        return vkRepository.getGroupPosts().response?.items
    }
}