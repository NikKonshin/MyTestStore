package com.nikitakonshin.repositories.interactors

import com.nikitakonshin.model.entities.local.main.Main
import com.nikitakonshin.repositories.repositories.MainRepository

class MainInteractorImpl(private val repository: MainRepository) :
    MainInteractor {

    override suspend fun getMain(): List<Main> = repository.getMain()
}