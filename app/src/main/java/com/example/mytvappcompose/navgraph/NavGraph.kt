package com.example.mytvappcompose.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytvappcompose.screens.HomeScreen
import com.example.mytvappcompose.screens.MainScreen


@Composable
fun NavGraph(navController: NavController, paddingValues: PaddingValues) {
     val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Main screen"){
        composable(route = "Main screen"){
            MainScreen(navController)
        }
        composable(route = "Home screen"){
            HomeScreen(navController)
        }
    }

}