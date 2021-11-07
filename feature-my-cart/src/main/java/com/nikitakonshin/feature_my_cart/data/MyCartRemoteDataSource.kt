package com.nikitakonshin.feature_my_cart.data

import com.nikitakonshin.feature_my_cart.data.model.remote.ResponseCart

interface MyCartRemoteDataSource {
    suspend fun getMyCart(): List<ResponseCart>
}