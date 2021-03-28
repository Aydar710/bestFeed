package com.aydar.domain

import com.aydar.data.local.*
import com.aydar.data.model.groupWallRemote.Item

fun Feed.toFeedCompound(): FeedCompound {
    val postsLocalCompund = mutableListOf<PostLocalCompound>()
    posts?.forEach { itemPost ->
        val postLocal = itemPost.toPostLocal()
        val postLocalCompound = PostLocalCompound(postLocal, itemPost.extractAttachments())
        postsLocalCompund.add(postLocalCompound)
    }
    return FeedCompound(feed = this, posts = postsLocalCompund)
}

fun Item.toPostLocal() = PostLocal(
    date = date,
    text = text
)

fun Item.extractAttachments(): MutableList<AttachmentLocal> {
    val attachmentsLocal = mutableListOf<AttachmentLocal>()
    attachments?.forEach { attachemnt ->
        if (attachemnt.type == "photo") {
            val biggestPhotoUrl = attachemnt.photo?.sizes?.last()?.url
            biggestPhotoUrl?.let {
                attachmentsLocal.add(
                    AttachmentLocal(type = attachemnt.type, photo = it)
                )
            }
        }
    }
    return attachmentsLocal
}
