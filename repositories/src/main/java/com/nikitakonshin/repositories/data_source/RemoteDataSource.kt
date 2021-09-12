package com.nikitakonshin.repositories.data_source

import com.nikitakonshin.model.entities.Main
import com.nikitakonshin.model.entities.cart.Cart
import com.nikitakonshin.model.entities.productdetails.ProductDetails

interface RemoteDataSource {
    suspend fun getMain(): List<Main>
    suspend fun getProductDetails(): List<ProductDetails>
    suspend fun getMyCart(): List<Cart>
}