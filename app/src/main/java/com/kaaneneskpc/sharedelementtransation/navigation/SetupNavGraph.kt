package com.kaaneneskpc.sharedelementtransation.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import com.kaaneneskpc.sharedelementtransation.presentation.screen.HomeScreen
import androidx.navigation.compose.composable
import com.kaaneneskpc.sharedelementtransation.presentation.screen.DetailsScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = Screen.Home.route) {
            composable(route = Screen.Home.route) {
                HomeScreen(
                    animatedVisibilityScope = this@composable,
                    onImageClick = { imageId ->
                        navController.navigate(Screen.Details.passImageId(imageId))
                    }
                )
            }
            composable(route = Screen.Details.route,
                arguments = listOf(navArgument(name = IMAGE_ID_ARG) {
                    type = NavType.IntType
                })
            ) {
                val imageId = it.arguments?.getInt(IMAGE_ID_ARG) ?: 1
                DetailsScreen(
                    animatedVisibilityScope = this@composable,
                    imageId = imageId,
                    onClick = { navController.popBackStack() }
                )
            }
        }
    }
}