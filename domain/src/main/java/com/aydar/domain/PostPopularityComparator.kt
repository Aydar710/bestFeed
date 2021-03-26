package com.aydar.domain

import com.aydar.data.model.groupWallRemote.Item

class PostPopularityComparator : Comparator<Item> {

    override fun compare(item1: Item?, item2: Item?): Int {
        val item1Popularity = (item1?.likes?.count).orZero()
            .plus(item1?.comments?.count ?: 0)
            .plus(item1?.reposts?.count ?: 0)

        val item2Popularity = (item2?.likes?.count).orZero()
            .plus(item2?.comments?.count ?: 0)
            .plus(item2?.reposts?.count ?: 0)

        return item1Popularity - item2Popularity
    }

    //TODO: extract to common module
    private fun Int?.orZero(): Int = this ?: 0
}