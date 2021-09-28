package com.nikitakonshin.feature_main_screen.domain

import com.nikitakonshin.model.entities.local.main.Main
import com.nikitakonshin.repositories.repositories.MainRepository

class MainInteractorImpl(private val repository: MainRepository) :
    MainInteractor {

    override suspend fun getMain(): Main = repository.getMain()
}