package com.mcl.eletriccarapp.data

import com.mcl.eletriccarapp.domain.Car

object CarFactory {
    val list = listOf(
        Car(
            id = 1,
            price = "R$ 450.000,00",
            battery = "300 kWh",
            power = "350cv",
            recharge = "30 min",
            urlPhoto = "www.google.com.br",
            isFavorite = false
        ),
        Car(
            id = 2,
            price = "R$ 400.000,00",
            battery = "350 kWh",
            power = "350cv",
            recharge = "30 min",
            urlPhoto = "www.google.com.br",
            isFavorite = false
        )
    )
}