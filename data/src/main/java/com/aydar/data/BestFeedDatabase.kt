package com.aydar.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aydar.data.dao.FeedDao
import com.aydar.data.local.AttachmentLocal
import com.aydar.data.local.Feed
import com.aydar.data.local.PostLocal

@Database(
    entities = [Feed::class, PostLocal::class, AttachmentLocal::class],
    version = 2,
    exportSchema = false
)
abstract class BestFeedDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDao
}