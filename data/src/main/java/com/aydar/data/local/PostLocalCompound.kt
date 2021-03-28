package com.aydar.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class PostLocalCompound(
    @Embedded
    val post: PostLocal,
    @Relation(parentColumn = "id", entityColumn = "postId", entity = AttachmentLocal::class)
    val attachments: List<AttachmentLocal>
)