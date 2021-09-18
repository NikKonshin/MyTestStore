package com.nikitakonshin.model.entities.local.main

import com.nikitakonshin.model.entities.local.ILocalData

data class HomeStore(
    val id: Int?,
    val isNew: Boolean?,
    val title: String?,
    val subtitle: String?,
    val picture: String?
) : ILocalData