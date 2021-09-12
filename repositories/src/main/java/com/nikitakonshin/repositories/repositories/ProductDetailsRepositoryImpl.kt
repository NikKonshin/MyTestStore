package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.productdetails.ProductDetails
import com.nikitakonshin.model.entities.responce.productdetails.ResponseProductDetails
import com.nikitakonshin.repositories.data_source.RemoteDataSource

class ProductDetailsRepositoryImpl(private val dataSource: RemoteDataSource) :
    ProductDetailsRepository {

    override suspend fun getProductDetails(): List<ProductDetails> {
        val listResponseProductDetails = dataSource.getProductDetails()
        return mapToListProductDetails(listResponseProductDetails)
    }

    private fun mapToListProductDetails(response: List<ResponseProductDetails>): List<ProductDetails> =
        response.map {
            ProductDetails(
                id = it.id,
                images = it.images,
                isFavorites = it.isFavorites,
                title = it.title,
                rating = it.rating,
                CPU = it.CPU,
                camera = it.camera,
                ssd = it.ssd,
                sd = it.sd,
                color = it.color,
                capacity = it.capacity,
                price = it.price
            )
        }
}