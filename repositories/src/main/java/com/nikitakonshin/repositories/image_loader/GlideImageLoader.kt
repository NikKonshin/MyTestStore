package com.nikitakonshin.repositories.image_loader

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader : ImageLoader {
    override fun loadImage(uri: String, view: ImageView) {
        Glide.with(view).load(uri).centerCrop().into(view)
    }
}