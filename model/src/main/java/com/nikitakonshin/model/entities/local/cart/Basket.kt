package com.nikitakonshin.model.entities.local.cart

import com.nikitakonshin.model.entities.local.ILocalData

data class Basket(
    val id: Int,
    val images: String?,
    val title: String?,
    val price: Int?
) : ILocalData