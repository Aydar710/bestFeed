package com.aydar.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class FeedCompound(
    @Embedded
    val feed: Feed,
    @Relation(
        parentColumn = "id",
        entityColumn = "feedId",
        entity = PostLocal::class
    )
    val posts: List<PostLocalCompound>
)