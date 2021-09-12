package com.nikitakonshin.repositories.data_source

import com.nikitakonshin.model.entities.responce.main.ResponseMain
import com.nikitakonshin.model.entities.responce.cart.ResponseCart
import com.nikitakonshin.model.entities.responce.productdetails.ResponseProductDetails
import com.nikitakonshin.repositories.api.ApiService

class RemoteDataSourceImpl(private val api: ApiService):
    RemoteDataSource {
    override suspend fun getMain(): List<ResponseMain> = api.getMainAsync().await()
    override suspend fun getProductDetails(): List<ResponseProductDetails> = api.getProductDetailsAsync().await()
    override suspend fun getMyCart(): List<ResponseCart> = api.getMyCartAsync().await()
}