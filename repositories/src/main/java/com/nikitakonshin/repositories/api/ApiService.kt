package com.nikitakonshin.repositories.api

import com.nikitakonshin.model.entities.responce.main.ResponseMain
import com.nikitakonshin.model.entities.responce.cart.ResponseCart
import com.nikitakonshin.model.entities.responce.productdetails.ResponseProductDetails
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("/rest/main")
    fun getMainAsync(): Deferred<List<ResponseMain>>

    @GET("/rest/productdetails")
    fun getProductDetailsAsync(): Deferred<List<ResponseProductDetails>>

    @GET("/rest/mycart")
    fun getMyCartAsync(): Deferred<List<ResponseCart>>
}