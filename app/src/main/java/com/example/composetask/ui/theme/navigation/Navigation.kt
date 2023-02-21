package com.example.composetask.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetask.ui.theme.view.CreateRecordPage
import com.example.composetask.ui.theme.view.MainPage

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainPage(navController = navController) {
            }
        }
        composable(route = Screen.CreateRecord.route) {
            CreateRecordPage()
        }

    }
}