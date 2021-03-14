package com.aydar.domain

import com.aydar.data.model.groupWallRemote.GroupWallResponseWrapper
import com.aydar.data.repository.VkRepository
import javax.inject.Inject

class GetGroupPostsInteractor @Inject constructor(private val vkRepository: VkRepository) {

    suspend fun getGroupPosts(): GroupWallResponseWrapper {
        val posts = vkRepository.getGroupPosts()
        return posts
    }
}