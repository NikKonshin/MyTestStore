package com.nikitakonshin.repositories.api

import com.nikitakonshin.model.entities.Main
import com.nikitakonshin.model.entities.cart.Cart
import com.nikitakonshin.model.entities.productdetails.ProductDetails
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("/rest/main")
    fun getMainAsync(): Deferred<List<Main>>

    @GET("/rest/productdetails")
    fun getProductDetailsAsync(): Deferred<List<ProductDetails>>

    @GET("/rest/mycart")
    fun getMyCartAsync(): Deferred<List<Cart>>
}