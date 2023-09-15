package com.mcl.eletriccarapp.domain

data class Car (
    val id: Int,
    val price: String,
    val battery: String,
    val power: String,
    val recharge: String,
    val urlPhoto: String,
    var isFavorite: Boolean
)