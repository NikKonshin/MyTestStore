package com.nikitakonshin.model.entities.local.main

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nikitakonshin.model.entities.local.ILocalData
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeStore(
    @SerializedName("id") val id: Int,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("picture") val picture: String
) : Parcelable, ILocalData