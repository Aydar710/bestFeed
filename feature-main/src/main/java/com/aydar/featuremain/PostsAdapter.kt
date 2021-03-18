package com.aydar.featuremain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aydar.data.model.groupWallRemote.Item
import com.aydar.featuremain.databinding.ItemFeedBinding

class PostsAdapter : ListAdapter<Item, PostsAdapter.PostViewHolder>(PostDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFeedBinding.inflate(layoutInflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class PostViewHolder(val binding: ItemFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Item) {
            binding.tvText.text = post.text ?: ""

            post.attachments?.let { attachments ->
                if (attachments.isNotEmpty()) {
                    val photos = attachments.map {
                        it.photo?.sizes?.last()?.url
                    }.filterNotNull()
                    val photosAdapter = PhotosAdapter()
                    binding.vpPhotos.adapter = photosAdapter

                    binding.vpPhotos.addItemDecoration(
                        HorizontalSpaceItemDecorator(
                            binding.root.context.resources.getDimension(R.dimen.viewpager_space)
                                .toInt()
                        )
                    )

                    photosAdapter.submitList(photos)
                }
            }
        }
    }
}


object PostDiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = false

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = false

}