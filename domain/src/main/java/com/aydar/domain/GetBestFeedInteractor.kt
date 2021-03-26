package com.aydar.domain

import android.text.format.DateUtils
import com.aydar.data.model.groupWallRemote.Item
import javax.inject.Inject

class GetBestFeedInteractor @Inject constructor(private val getGroupPostsInteractor: GetGroupPostsInteractor) {

    suspend operator fun invoke(domains: List<String>): List<Item> {
        val allPosts = mutableListOf<Item>()
        domains.forEach { domain ->
            allPosts.addAll(getAllTodayPosts(domain))
        }

        return allPosts.filteredByMostPopular(5)
    }

    private suspend fun getAllTodayPosts(domain: String): List<Item> {
        val todaysPosts = mutableListOf<Item>()
        var offset = 0
        var todaysPostsAreOver = false
        while (!todaysPostsAreOver) {
            val posts = getGroupPostsInteractor(domain, offset)

            val todaysPostsFiltered = posts?.filter {
                DateUtils.isToday(it.date?.toLong()?.times(1000) ?: 0)
            }

            if (todaysPostsFiltered?.isNotEmpty() == true) {
                todaysPosts.addAll(todaysPostsFiltered)
                offset += posts.size
            } else {
                todaysPostsAreOver = true
            }
        }

        return todaysPosts
    }

    private fun List<Item>.filteredByMostPopular(count: Int): List<Item> {
        return toMutableList().sortedWith(PostPopularityComparator()).take(count)
    }
}