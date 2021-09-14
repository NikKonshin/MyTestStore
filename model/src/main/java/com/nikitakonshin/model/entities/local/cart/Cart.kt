package com.nikitakonshin.model.entities.local.cart

import com.nikitakonshin.model.entities.local.ILocalData

data class Cart(
    val id : String,
    val basket : List<Basket>,
    val total : Int,
    val delivery : String
): ILocalData