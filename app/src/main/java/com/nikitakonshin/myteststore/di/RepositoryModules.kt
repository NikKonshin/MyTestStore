package com.nikitakonshin.myteststore.di

import com.nikitakonshin.feature_main_screen.domain.MainInteractor
import com.nikitakonshin.feature_main_screen.domain.MainInteractorImpl
import com.nikitakonshin.feature_product_details.domain.ProductDetailsInteractor
import com.nikitakonshin.feature_product_details.domain.ProductDetailsInteractorImpl
import com.nikitakonshin.model.entities.local.productdetails.ListProductDetails
import com.nikitakonshin.model.entities.local.productdetails.ProductDetails
import com.nikitakonshin.repositories.data_source.RemoteDataSource
import com.nikitakonshin.repositories.data_source.RemoteDataSourceImpl
import com.nikitakonshin.repositories.image_loader.GlideImageLoader
import com.nikitakonshin.repositories.image_loader.ImageLoader
import com.nikitakonshin.repositories.local_data_source.LocalDataSource
import com.nikitakonshin.repositories.local_data_source.LocalDataSourceImpl
import com.nikitakonshin.repositories.repositories.MainRepository
import com.nikitakonshin.repositories.repositories.MainRepositoryImpl
import com.nikitakonshin.repositories.repositories.ProductDetailsRepository
import com.nikitakonshin.repositories.repositories.ProductDetailsRepositoryImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<LocalDataSource<ProductDetails>> { LocalDataSourceImpl(get()) }
}

val repositoryModule = module {
    single { ListProductDetails() }
    single<MainRepository> { MainRepositoryImpl(get()) }
    single<ProductDetailsRepository> { ProductDetailsRepositoryImpl(get(), get()) }
}

val interactorModule = module {
    single<MainInteractor> { MainInteractorImpl(get()) }
    single<ProductDetailsInteractor> { ProductDetailsInteractorImpl(get()) }
}

val imageModule = module {
    single<ImageLoader> { GlideImageLoader() }
}