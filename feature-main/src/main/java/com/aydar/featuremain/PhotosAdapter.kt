package com.aydar.featuremain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aydar.featuremain.databinding.ItemImageBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class PhotosAdapter : ListAdapter<String, PhotosAdapter.ImageViewHolder>(ImageDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemImageBinding.inflate(layoutInflater, parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: String) {
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(RoundedCorners(16))

            Glide.with(binding.root.context)
                .load(image)
                .apply(requestOptions)
                .thumbnail(0.01f)
                .into(binding.ivPhoto)
        }
    }
}

object ImageDiffCallback : DiffUtil.ItemCallback<String>() {

    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = false

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = false

}