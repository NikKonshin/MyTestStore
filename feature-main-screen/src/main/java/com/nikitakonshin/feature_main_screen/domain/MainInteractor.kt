package com.nikitakonshin.feature_main_screen.domain

import com.nikitakonshin.model.entities.local.main.Main

interface MainInteractor {
    suspend fun getMain(): Main
}