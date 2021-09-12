package com.nikitakonshin.model.entities.responce.cart

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nikitakonshin.model.entities.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
class ResponseBasket(
    @SerializedName("images") val images : String,
    @SerializedName("title") val title : String,
    @SerializedName("price") val price : Int
):Parcelable, IResponseData