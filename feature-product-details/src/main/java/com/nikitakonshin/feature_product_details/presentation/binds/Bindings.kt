package com.nikitakonshin.feature_product_details.presentation.binds

import android.view.View
import com.nikitakonshin.core.adapter.BaseItemListener
import com.nikitakonshin.feature_product_details.databinding.ItemPhotoPhoneBinding
import com.nikitakonshin.repositories.image_loader.ImageLoader

fun bindProductDetails(
    view: View,
    data: String,
    listener: BaseItemListener,
    imageLoader: ImageLoader
) {
    val binding = ItemPhotoPhoneBinding.bind(view)
    imageLoader.loadImage(data, binding.ivPhoneItemPhotoPhone)
}