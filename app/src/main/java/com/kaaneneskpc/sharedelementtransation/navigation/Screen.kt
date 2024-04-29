package com.kaaneneskpc.sharedelementtransation.navigation

const val IMAGE_ID_ARG = "imageId"

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Details : Screen("details_screen/{$IMAGE_ID_ARG}") {
        fun passImageId(imageId: Int) = "details_screen/$imageId"
    }
}

