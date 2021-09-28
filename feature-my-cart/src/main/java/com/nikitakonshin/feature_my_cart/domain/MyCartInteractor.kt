package com.nikitakonshin.feature_my_cart.domain

import com.nikitakonshin.model.entities.local.cart.Cart

interface MyCartInteractor {
    suspend fun getCart(): Cart
}