package com.nikitakonshin.repositories.interactors

import com.nikitakonshin.model.entities.local.cart.Cart
import com.nikitakonshin.repositories.repositories.MyCartRepository

class MyCartInteractorImpl(private val repository: MyCartRepository) :
    MyCartInteractor {

    override suspend fun getCart(): Cart = repository.getCart()
}