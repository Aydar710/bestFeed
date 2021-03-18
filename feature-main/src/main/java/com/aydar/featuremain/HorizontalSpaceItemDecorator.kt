package com.aydar.featuremain

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalSpaceItemDecorator : RecyclerView.ItemDecoration {
    var space: Int
    var isHorizontalLayout = false

    constructor(space: Int) {
        this.space = space
    }

    constructor(space: Int, isHorizontalLayout: Boolean) {
        this.space = space
        this.isHorizontalLayout = isHorizontalLayout
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left = space
            outRect.right = space
        } else {
            outRect.left = space
            outRect.right = space
        }
    }
}