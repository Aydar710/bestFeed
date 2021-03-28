package com.aydar.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class AttachmentLocal(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,
        @ForeignKey(
                entity = PostLocal::class,
                parentColumns = ["id"],
                childColumns = ["postId"],
                onDelete = ForeignKey.CASCADE
        )
        val postId: Int,
        val type: String? = null,
        val photo: String? = null,
)