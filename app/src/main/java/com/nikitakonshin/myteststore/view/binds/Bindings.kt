package com.nikitakonshin.myteststore.view.binds

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import com.nikitakonshin.core.adapter.BaseItemListener
import com.nikitakonshin.model.entities.local.main.BestSeller
import com.nikitakonshin.model.entities.local.main.HomeStore
import com.nikitakonshin.myteststore.R
import com.nikitakonshin.myteststore.databinding.ItemBestSellerBinding
import com.nikitakonshin.myteststore.databinding.ItemHotSalesBinding
import com.nikitakonshin.repositories.image_loader.ImageLoader
import java.lang.StringBuilder

internal fun bindHotSales(
    view: View,
    data: HomeStore,
    listener: BaseItemListener,
    imageLoader: ImageLoader
) {
    val binding = ItemHotSalesBinding.bind(view)
    val urlPicture = data.picture
    val title = data.title
    val subtitle = data.subtitle
    val isNew = data.isNew ?: false
    with(binding) {
        urlPicture?.let {
            imageLoader.loadImage(it, ivPhoneHotSales)
        }
        tvPhoneName.text = title
        tvPhoneDescription.text = subtitle
        if (!isNew) ivNew.visibility = View.INVISIBLE
    }

}

internal fun bindBestSeller(
    view: View,
    data: BestSeller,
    listener: BaseItemListener,
    imageLoader: ImageLoader
) {
    val binding: ItemBestSellerBinding = ItemBestSellerBinding.bind(view)
    val discountPrise = mapIntToPrice(data.discountPrice?:0)
    val priceWithoutDiscount = mapIntToPrice(data.priceWithoutDiscount?:0)
    val uri = data.picture
    val isFavorites = data.isFavorites ?: false
    val title = data.title

    val span = SpannableString(priceWithoutDiscount)
    span.setSpan(StrikethroughSpan(), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    with(binding) {
        uri?.let { imageLoader.loadImage(it, ivPhoneBestSeller) }
        tvModelPhone.text = title
        tvDiscountPrice.text = discountPrise
        tvPriceWithoutDiscount.text = span
        if (isFavorites) ivLikeBestSeller.setImageResource(R.drawable.like)
    }
}

private fun mapIntToPrice(price: Int): String {
    val newPrice: String =
        if (price >= 1000) {
            val strPrise = StringBuilder(price.toString())
            strPrise.insert(1,",")
            strPrise.toString()
        } else {
            price.toString()
        }

    return  "$$newPrice"
}