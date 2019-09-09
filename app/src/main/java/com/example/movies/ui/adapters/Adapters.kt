package com.example.movies.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.movies.BuildConfig.base_image

object Adapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            Glide.with(imageView.context)
                .load(base_image + imgUrl)
                .into(imageView)
        }
    }
}

