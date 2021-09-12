package com.nikitakonshin.model.entities.productdetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDetails(
    @SerializedName("_id") val id : String,
    @SerializedName("images") val images : List<String>,
    @SerializedName("is_favorites") val isFavorites : Boolean,
    @SerializedName("title") val title : String,
    @SerializedName("rating") val rating : Double,
    @SerializedName("CPU") val CPU : String,
    @SerializedName("camera") val camera : String,
    @SerializedName("ssd") val ssd : String,
    @SerializedName("sd") val sd : String,
    @SerializedName("color") val color : List<String>,
    @SerializedName("capacity") val capacity : List<String>,
    @SerializedName("price") val price : Int
):Parcelable