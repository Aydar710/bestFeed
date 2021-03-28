package com.aydar.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Transaction
import com.aydar.data.local.AttachmentLocal
import com.aydar.data.local.Feed
import com.aydar.data.local.FeedCompound
import com.aydar.data.local.PostLocal

@Dao
interface FeedDao {

    @Transaction
    suspend fun insert(feedCompound: FeedCompound) {
        val feedId = insertFeed(feedCompound.feed)
        feedCompound.posts.forEach { postLocalCompound ->
            val postId = insertPostLocal(postLocalCompound.post.copy(feedId = feedId))
            postLocalCompound.attachments.forEach { attachmentLocal ->
                insertAttachments(attachmentLocal.copy(postId = postId))
            }
        }
    }

    @Insert
    suspend fun insertFeed(feed: Feed): Long

    @Insert
    suspend fun insertPostLocal(postLocal: PostLocal): Long

    @Insert
    suspend fun insertAttachments(attachmentLocal: AttachmentLocal)

/*
    @Transaction
    @Query("SELECT * FROM Feed WHERE id = :id")
    suspend fun getFeedById(id: Int): List<FeedCompound>
*/
}