package com.aydar.data.repository

import com.aydar.data.dao.FeedDao
import com.aydar.data.local.FeedCompound
import javax.inject.Inject

class FeedRepository @Inject constructor(private val feedDao: FeedDao) {

    suspend fun saveFeed(feedCompound: FeedCompound) {
        feedDao.insert(feedCompound)
    }
}