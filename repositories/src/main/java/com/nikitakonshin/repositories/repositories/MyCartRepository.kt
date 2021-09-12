package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.cart.Cart

interface MyCartRepository {
    suspend fun getCart(): List<Cart>
}