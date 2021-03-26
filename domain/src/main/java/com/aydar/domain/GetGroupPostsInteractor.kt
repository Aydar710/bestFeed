package com.aydar.domain

import com.aydar.data.model.groupWallRemote.Item
import com.aydar.data.repository.VkRepository
import javax.inject.Inject

class GetGroupPostsInteractor @Inject constructor(private val vkRepository: VkRepository) {

    suspend operator fun invoke(domain: String, offset: Int): List<Item>? {
        return vkRepository.getGroupPosts(domain, offset).response?.items
    }
}