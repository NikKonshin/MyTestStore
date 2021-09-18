package com.nikitakonshin.model.entities.local.main

import com.nikitakonshin.model.entities.local.ILocalData

data class BestSeller(
    val id: Int?,
    val isFavorites: Boolean?,
    val title: String?,
    val priceWithoutDiscount: Int?,
    val discountPrice: Int?,
    val picture: String?
) : ILocalData

