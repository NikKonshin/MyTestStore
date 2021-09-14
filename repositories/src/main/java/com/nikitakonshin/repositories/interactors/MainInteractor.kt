package com.nikitakonshin.repositories.interactors

import com.nikitakonshin.model.entities.local.main.Main

interface MainInteractor {
    suspend fun getMain(): Main
}