package com.nikitakonshin.feature_product_details.domain

import com.nikitakonshin.model.entities.local.productdetails.ProductDetails

interface ProductDetailsInteractor {
    suspend fun getProductDetails(id: String): ProductDetails?
}