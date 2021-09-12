package com.nikitakonshin.repositories.data_source

import com.nikitakonshin.model.entities.Main
import com.nikitakonshin.model.entities.cart.Cart
import com.nikitakonshin.model.entities.productdetails.ProductDetails
import com.nikitakonshin.repositories.api.ApiService

class RemoteDataSourceImpl(private val api: ApiService):
    RemoteDataSource {
    override suspend fun getMain(): List<Main> = api.getMainAsync().await()
    override suspend fun getProductDetails(): List<ProductDetails> = api.getProductDetailsAsync().await()
    override suspend fun getMyCart(): List<Cart> = api.getMyCartAsync().await()
}