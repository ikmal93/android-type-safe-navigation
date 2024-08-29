package com.ikmal.android_type_safe_navigation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.ikmal.android_type_safe_navigation.presentation.home.HomeScreen
import com.ikmal.android_type_safe_navigation.presentation.product.ProductDetailScreen
import com.ikmal.android_type_safe_navigation.presentation.product.ProductListScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: Screen = Screen.Home
) {
    /**
     * Guide for animation transition see here :
     * - https://www.youtube.com/watch?v=MhXa-5Arw3Q
     * - https://tomas-repcik.medium.com/jetpack-compose-and-screen-transition-animations-b361fc8164cc
     */
    NavHost(navController, startDestination) {
        composable<Screen.Home>(
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
                )
            },
        ) {
            HomeScreen {
                navController.navigate(Screen.ProductList(id = 1))
            }
        }
        composable<Screen.ProductList>(
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(500)
                )
            },
        ) { backStackEntry ->
            val data = backStackEntry.toRoute<Screen.ProductList>()
            ProductListScreen(
                id = data.id,
                onBackPressed = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                },
                onClick = {
                    navController.navigate(Screen.ProductDetail(id = 1))
                },
            )
        }
        composable<Screen.ProductDetail>(
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(500)
                )
            },
        ) { backStackEntry ->
            val data = backStackEntry.toRoute<Screen.ProductDetail>()
            ProductDetailScreen(
                id = data.id,
                onBackPressed = {
                    if (navController.canGoBack) {
                        navController.popBackStack()
                    }
                },
                onClick = {

                }
            )
        }
    }
}

val NavHostController.canGoBack: Boolean
    get() = this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED