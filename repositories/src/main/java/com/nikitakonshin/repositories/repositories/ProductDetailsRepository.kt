package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.productdetails.ProductDetails

interface ProductDetailsRepository {
    suspend fun getProductDetails(): List<ProductDetails>
}