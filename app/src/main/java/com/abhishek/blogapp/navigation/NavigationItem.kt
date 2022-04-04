package com.abhishek.blogapp.navigation

sealed class NavigationItem(val route : String) {
    object Home : NavigationItem("Home")
    object DetailScreen : NavigationItem("Details")
}
