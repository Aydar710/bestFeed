package com.aydar.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.aydar.data.local.AttachmentLocal
import com.aydar.data.local.Feed
import com.aydar.data.local.FeedCompound
import com.aydar.data.local.PostLocal

@Dao
interface FeedDao {

    @Transaction
    suspend fun insert(feedCompound: FeedCompound) {
        insertFeed(feedCompound.feed)
        feedCompound.posts.forEach { postLocalCompound ->
            insertPostLocal(postLocalCompound.post)
            insertAttachments(postLocalCompound.attachments)
        }
    }

    @Insert
    suspend fun insertFeed(feed: Feed)

    @Insert
    suspend fun insertPostLocal(postLocal: PostLocal)

    @Insert
    suspend fun insertAttachments(attachmentsLocal: List<AttachmentLocal>)

    @Query("SELECT * FROM Feed WHERE id = :id")
    suspend fun getFeedById(id: Int): List<FeedCompound>
}