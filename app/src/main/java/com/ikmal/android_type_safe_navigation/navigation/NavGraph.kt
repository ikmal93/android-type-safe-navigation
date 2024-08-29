package com.ikmal.android_type_safe_navigation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ikmal.android_type_safe_navigation.presentation.home.homeScreen
import com.ikmal.android_type_safe_navigation.presentation.product.productDetailScreen
import com.ikmal.android_type_safe_navigation.presentation.product.productListScreen

@Composable
fun SetupNavGraph(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: Screen = Screen.Home
) {
    /**
     * Guide for animation transition see here :
     * - https://www.youtube.com/watch?v=MhXa-5Arw3Q
     * - https://tomas-repcik.medium.com/jetpack-compose-and-screen-transition-animations-b361fc8164cc
     */
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        homeScreen(navController)
        productListScreen(navController)
        productDetailScreen(navController)
    }
}