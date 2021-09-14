package com.nikitakonshin.repositories.repositories

import com.nikitakonshin.model.entities.local.main.Main

interface MainRepository {
    suspend fun getMain(): Main
}