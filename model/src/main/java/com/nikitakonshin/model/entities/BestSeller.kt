package com.nikitakonshin.model.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BestSeller(
    @SerializedName("id") val id: Int,
    @SerializedName("is_favorites") val isFavorites: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("price_without_discount") val priceWithoutDiscount: Int,
    @SerializedName("discount_price") val discountPrice: Int,
    @SerializedName("picture") val picture: String
) : Parcelable

