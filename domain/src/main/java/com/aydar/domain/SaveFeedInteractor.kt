package com.aydar.domain

import com.aydar.data.local.Feed
import com.aydar.data.model.groupWallRemote.Item
import com.aydar.data.repository.FeedRepository
import javax.inject.Inject

class SaveFeedInteractor @Inject constructor(private val feedRepository: FeedRepository) {

    suspend operator fun invoke(items: List<Item>) {
        val feed = Feed(posts = items)
        val feedCompound = feed.toFeedCompound()
        feedRepository.saveFeed(feedCompound)
    }
}