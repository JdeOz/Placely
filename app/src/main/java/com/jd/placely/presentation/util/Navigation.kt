package com.jd.placely.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jd.placely.presentation.login.LoginScreen
import com.jd.placely.presentation.main_feed.MainFeedScreen
import com.jd.placely.presentation.map.MapScreen
import com.jd.placely.presentation.register.RegisterScreen
import com.jd.placely.presentation.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route){
            MainFeedScreen(navController = navController)
        }
        composable(Screen.MapScreen.route){
            MapScreen(navController = navController)
        }
    }
}