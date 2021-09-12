package com.nikitakonshin.repositories.interactors

import com.nikitakonshin.model.entities.local.productdetails.ProductDetails

interface ProductDetailsInteractor{
    suspend fun getProductDetails(): List<ProductDetails>
}