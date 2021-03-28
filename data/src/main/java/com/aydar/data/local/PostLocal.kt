package com.aydar.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class PostLocal(
        @PrimaryKey
        val id: Int = 0,
        @ForeignKey(
                entity = Feed::class,
                parentColumns = ["id"],
                childColumns = ["feedId"],
                onDelete = ForeignKey.CASCADE
        )
        val feedId: Int? = null,
        val date: Int? = null,
        val text: String? = null
)

