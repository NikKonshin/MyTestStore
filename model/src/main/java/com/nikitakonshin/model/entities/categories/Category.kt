package com.nikitakonshin.model.entities.categories

data class Category(
    val id: Int,
    val imageRes: Int,
    val description: String,
    var isSelected: Boolean = false
)