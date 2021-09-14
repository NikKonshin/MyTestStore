package com.nikitakonshin.model.entities.local.main

import com.nikitakonshin.model.entities.local.ILocalData

data class Main(
    val id: String,
    val homeStore: List<HomeStore>,
    val bestSeller: List<BestSeller>
) : ILocalData