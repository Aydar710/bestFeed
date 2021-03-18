package com.aydar.featuremain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aydar.data.model.groupWallRemote.Item
import com.aydar.featuremain.databinding.ItemFeedBinding
import com.bumptech.glide.Glide

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
            binding.tvText.text = "123456789123456789123456789123456789"
            binding.ivPhoto.setImageResource(R.drawable.san_fran)

            post.attachments?.let { attachments ->
                if (attachments.isNotEmpty()) {
                    val photo = attachments[0].photo?.sizes?.last()?.url

                    photo?.let {
                        Glide.with(binding.root.context)
                            .load(it)
                            .placeholder(R.drawable.san_fran)
                            .into(binding.ivPhoto)

                        android.os.Handler().postDelayed({
                            binding.root.invalidate()
                        }, 3000)
                    }
                }
            }
        }
    }
}


object PostDiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = false

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = false

}