package com.nikitakonshin.model.entities.cart

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cart(
    @SerializedName("_id") val id : String,
    @SerializedName("basket") val basket : List<Basket>,
    @SerializedName("total") val total : Int,
    @SerializedName("Delivery") val delivery : String
):Parcelable