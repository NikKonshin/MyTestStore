package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.cart.Basket
import com.nikitakonshin.model.entities.local.cart.Cart
import com.nikitakonshin.model.entities.responce.cart.ResponseCart
import com.nikitakonshin.repositories.data_source.RemoteDataSource

class MyCartRepositoryImpl(private val dataSource: RemoteDataSource) :
    MyCartRepository {
    override suspend fun getCart(): List<Cart> {
        val listResponseCart = dataSource.getMyCart()
        return mapToCart(listResponseCart)
    }

    private fun mapToCart(response: List<ResponseCart>): List<Cart> =
        response.map { responseCart ->
            Cart(
                id = responseCart.id,
                basket = responseCart.basket.map { responseBasket ->
                    Basket(
                        images = responseBasket.images,
                        title = responseBasket.title,
                        price = responseBasket.price
                    )
                },
                total = responseCart.total,
                delivery = responseCart.delivery
            )
        }
}