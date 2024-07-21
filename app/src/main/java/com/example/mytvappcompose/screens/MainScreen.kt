package com.example.mytvappcompose.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.mytvappcompose.TopNavigationBar
import com.example.mytvappcompose.navgraph.NavGraph
@Composable
fun MainScreen(navController: NavController) {
    Scaffold(
        topBar = { TopNavigationBar() },
        content = { paddingValues ->
            // Use paddingValues here to apply padding to the content
            NavGraph(navController, paddingValues)
        }
    )
}

