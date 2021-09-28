package com.nikitakonshin.feature_product_details.domain

import com.nikitakonshin.model.entities.local.productdetails.ProductDetails
import com.nikitakonshin.repositories.repositories.ProductDetailsRepository

class ProductDetailsInteractorImpl(private val repository: ProductDetailsRepository) :
    ProductDetailsInteractor {

    override suspend fun getProductDetails(id: String): ProductDetails? =
        repository.getProductDetails(id)
}