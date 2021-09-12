package com.nikitakonshin.model.entities.local.cart

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nikitakonshin.model.entities.local.ILocalData
import kotlinx.parcelize.Parcelize

@Parcelize
class Basket(
    @SerializedName("images") val images : String,
    @SerializedName("title") val title : String,
    @SerializedName("price") val price : Int
):Parcelable, ILocalData