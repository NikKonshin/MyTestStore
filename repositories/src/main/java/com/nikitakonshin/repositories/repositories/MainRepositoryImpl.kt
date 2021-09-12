package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.main.BestSeller
import com.nikitakonshin.model.entities.local.main.HomeStore
import com.nikitakonshin.model.entities.local.main.Main
import com.nikitakonshin.model.entities.responce.main.ResponseMain
import com.nikitakonshin.repositories.data_source.RemoteDataSource

class MainRepositoryImpl(private val dataSource: RemoteDataSource) :
    MainRepository {
    override suspend fun getMain(): List<Main> {
        val responseMain = dataSource.getMain()
        return mapToListMain(responseMain)
    }

    private fun mapToListMain(response: List<ResponseMain>): List<Main> =
        response.map { responseMain ->
            Main(
                id = responseMain.id,
                homeStore = responseMain.homeStore.map { responseHomeStore ->
                    HomeStore(
                        id = responseHomeStore.id,
                        isNew = responseHomeStore.isNew,
                        title = responseHomeStore.title,
                        subtitle = responseHomeStore.subtitle,
                        picture = responseHomeStore.picture
                    )
                },
                bestSeller = responseMain.bestSeller.map { responseBestSeller ->
                    BestSeller(
                        id = responseBestSeller.id,
                        isFavorites = responseBestSeller.isFavorites,
                        title = responseBestSeller.title,
                        priceWithoutDiscount = responseBestSeller.priceWithoutDiscount,
                        discountPrice = responseBestSeller.discountPrice,
                        picture = responseBestSeller.picture
                    )
                }
            )
        }
}