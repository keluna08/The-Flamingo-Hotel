package com.example.flamingohotel.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.flamingohotel.ui.theme.Screens.BookingScreen.BookingPage
import com.example.flamingohotel.ui.theme.Screens.Final.FinalPage
import com.example.flamingohotel.ui.theme.Screens.Home.MyListcustom
import com.example.flamingohotel.ui.theme.Screens.Login.LoginScreen
import com.example.flamingohotel.ui.theme.Screens.Register.RegisterScreen
import com.example.flamingohotel.ui.theme.Screens.Splash.SplashScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(), startDestination:String= ROUTE_SPLASH) {
    NavHost(navController =navController,modifier=modifier,startDestination=startDestination){
       composable(ROUTE_SPLASH){
            SplashScreen(navController)
       }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_HOME){
            MyListcustom(navController)
        }
        composable(ROUTE_BOOKING){
            BookingPage(navController)
        }
        composable(ROUTE_FINAL){
            FinalPage(navController)
        }
    }



}