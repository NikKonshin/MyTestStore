package com.nikitakonshin.model.entities.local.cart

import com.nikitakonshin.model.entities.local.ILocalData

class Basket(
    val images : String,
    val title : String,
    val price : Int
) : ILocalData