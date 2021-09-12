package com.nikitakonshin.model.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Main(
    @SerializedName("_id") val _id: String,
    @SerializedName("home_store") val homeStore: List<HomeStore>,
    @SerializedName("best_seller") val bestSeller: List<BestSeller>
) : Parcelable, IResponseData