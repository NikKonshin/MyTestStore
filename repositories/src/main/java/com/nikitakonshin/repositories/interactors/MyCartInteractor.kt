package com.nikitakonshin.repositories.interactors

import com.nikitakonshin.model.entities.local.cart.Cart

interface MyCartInteractor {
    suspend fun getCart(): List<Cart>
}