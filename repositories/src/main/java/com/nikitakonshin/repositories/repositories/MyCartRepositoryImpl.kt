package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.cart.Basket
import com.nikitakonshin.model.entities.local.cart.Cart
import com.nikitakonshin.model.entities.responce.cart.ResponseBasket
import com.nikitakonshin.model.entities.responce.cart.ResponseCart
import com.nikitakonshin.repositories.data_source.RemoteDataSource

class MyCartRepositoryImpl(private val dataSource: RemoteDataSource) :
    MyCartRepository {
    override suspend fun getCart(): Cart {
        val listResponseCart = dataSource.getMyCart()
        return mapToCart(listResponseCart)
    }

    private fun mapToCart(response: List<ResponseCart>): Cart {
        val responseCart = response[0]
        val basket = mapToListBasket(responseCart.basket)
        return Cart(
            id = responseCart.id,
            basket = basket,
            total = responseCart.total,
            delivery = responseCart.delivery
        )
    }

    private fun mapToListBasket(rBasket: List<ResponseBasket>): List<Basket> =
        rBasket.map { responseBasket ->
            Basket(
                images = responseBasket.images,
                title = responseBasket.title,
                price = responseBasket.price
            )
        }
}