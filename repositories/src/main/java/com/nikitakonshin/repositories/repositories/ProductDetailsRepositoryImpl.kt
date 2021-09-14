package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.productdetails.ProductDetails
import com.nikitakonshin.model.entities.responce.productdetails.ResponseProductDetails
import com.nikitakonshin.repositories.data_source.RemoteDataSource

class ProductDetailsRepositoryImpl(private val dataSource: RemoteDataSource) :
    ProductDetailsRepository {

    override suspend fun getProductDetails(): ProductDetails {
        val listResponseProductDetails = dataSource.getProductDetails()
        return mapToListProductDetails(listResponseProductDetails)
    }

    private fun mapToListProductDetails(response: List<ResponseProductDetails>): ProductDetails {
        val responseProductDetails = response[0]
        return ProductDetails(
            id = responseProductDetails.id,
            images = responseProductDetails.images,
            isFavorites = responseProductDetails.isFavorites,
            title = responseProductDetails.title,
            rating = responseProductDetails.rating,
            CPU = responseProductDetails.CPU,
            camera = responseProductDetails.camera,
            ssd = responseProductDetails.ssd,
            sd = responseProductDetails.sd,
            color = responseProductDetails.color,
            capacity = responseProductDetails.capacity,
            price = responseProductDetails.price
        )
    }
}