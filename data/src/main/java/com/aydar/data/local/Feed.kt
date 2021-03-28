package com.aydar.data.local

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.aydar.data.model.groupWallRemote.Item
import java.util.*

@Entity
data class Feed(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var date: Long = Date().time,

    @Ignore
    var posts: List<Item>? = null
)
