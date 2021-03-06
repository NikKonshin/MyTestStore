package com.nikitakonshin.feature_my_cart.domain

import com.nikitakonshin.feature_my_cart.data.model.local.Cart

interface MyCartInteractor {
    suspend fun getCart(): Cart
}