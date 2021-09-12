package com.nikitakonshin.repositories.interactors

import com.nikitakonshin.model.entities.local.productdetails.ProductDetails
import com.nikitakonshin.repositories.repositories.ProductDetailsRepository

class ProductDetailsInteractorImpl(private val repository: ProductDetailsRepository) :
    ProductDetailsInteractor {

    override suspend fun getProductDetails(): List<ProductDetails> =
        repository.getProductDetails()
}