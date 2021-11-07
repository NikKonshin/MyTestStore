package com.nikitakonshin.repositories.data_source

import com.nikitakonshin.model.entities.responce.main.ResponseMain
import com.nikitakonshin.model.entities.responce.productdetails.ResponseProductDetails

interface RemoteDataSource {
    suspend fun getMain(): List<ResponseMain>
    suspend fun getProductDetails(): List<ResponseProductDetails>
}