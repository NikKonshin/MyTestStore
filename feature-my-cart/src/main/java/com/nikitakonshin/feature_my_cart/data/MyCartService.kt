package com.nikitakonshin.feature_my_cart.data

import com.nikitakonshin.feature_my_cart.data.model.remote.ResponseCart
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MyCartService {
    @GET("/rest/mycart")
    fun getMyCartAsync(): Deferred<List<ResponseCart>>
}