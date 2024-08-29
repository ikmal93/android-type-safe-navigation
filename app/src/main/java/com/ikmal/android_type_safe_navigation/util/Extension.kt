package com.ikmal.android_type_safe_navigation.util

import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController

fun NavHostController.canGoBack(): Boolean {
    return this.currentBackStackEntry?.lifecycle?.currentState == Lifecycle.State.RESUMED
}