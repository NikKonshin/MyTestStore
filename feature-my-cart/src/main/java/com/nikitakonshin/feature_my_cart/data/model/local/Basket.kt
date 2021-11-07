package com.nikitakonshin.feature_my_cart.data.model.local

import com.nikitakonshin.model.entities.local.ILocalData

data class Basket(
    val id: Int,
    val images: String?,
    val title: String?,
    val price: Int?
) : ILocalData