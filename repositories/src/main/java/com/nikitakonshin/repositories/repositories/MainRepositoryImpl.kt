package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.main.BestSeller
import com.nikitakonshin.model.entities.local.main.HomeStore
import com.nikitakonshin.model.entities.local.main.Main
import com.nikitakonshin.model.entities.responce.main.ResponseBestSeller
import com.nikitakonshin.model.entities.responce.main.ResponseHomeStore
import com.nikitakonshin.model.entities.responce.main.ResponseMain
import com.nikitakonshin.repositories.data_source.RemoteDataSource

class MainRepositoryImpl(private val dataSource: RemoteDataSource) :
    MainRepository {

    override suspend fun getMain(): Main {
        val responseMain = dataSource.getMain()
        return mapToMain(responseMain)
    }

    private fun mapToMain(response: List<ResponseMain>): Main {
        val responseMain = response[0]
        val homeStore = mapToListHomeStore(responseMain.homeStore)
        val bestSeller = mapToListBestSeller(responseMain.bestSeller)
        return Main(
            id = responseMain.id,
            homeStore = homeStore,
            bestSeller = bestSeller
        )
    }

    private fun mapToListBestSeller(rBestSeller: List<ResponseBestSeller>): List<BestSeller> =
        rBestSeller.map { responseBestSeller ->
            BestSeller(
                id = responseBestSeller.id,
                isFavorites = responseBestSeller.isFavorites,
                title = responseBestSeller.title,
                priceWithoutDiscount = responseBestSeller.discountPrice,
                discountPrice = responseBestSeller.priceWithoutDiscount,
                picture = responseBestSeller.picture
            )
        }

    private fun mapToListHomeStore(rHomeStore: List<ResponseHomeStore>): List<HomeStore> =
        rHomeStore.map { responseHomeStore ->
            HomeStore(
                id = responseHomeStore.id,
                isNew = responseHomeStore.isNew,
                title = responseHomeStore.title,
                subtitle = responseHomeStore.subtitle,
                picture = responseHomeStore.picture
            )
        }
}