package com.ikmal.android_type_safe_navigation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()

    @Serializable
    data class ProductList(
        val id: Int
    ) : Screen()

    @Serializable
    data class ProductDetail(
        val id: Int
    ) : Screen()
}