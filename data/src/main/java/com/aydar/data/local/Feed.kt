package com.aydar.data.local

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.aydar.data.model.groupWallRemote.Item
import java.util.*

@Entity
data class Feed(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: Long = Date().time,

    @Ignore
    val posts: List<Item>
)
