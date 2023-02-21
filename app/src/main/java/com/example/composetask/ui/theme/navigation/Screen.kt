package com.example.composetask.ui.theme.navigation

sealed class Screen(val route: String){
    object MainScreen:Screen("main_screen")
    object CreateRecord:Screen("create_record_sreen")

    object StateScreen:Screen("state_screen")
}
