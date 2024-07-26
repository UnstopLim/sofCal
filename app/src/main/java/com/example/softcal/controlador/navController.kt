package com.example.softcal.controlador

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.softcal.componentes.view1
import com.example.softcal.componentes.view2
import com.example.softcal.componentes.view3

@Composable
fun navController() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "view1")
    {
        composable("view1")
        {
            view1(navController = navController)
        }

        composable("view2")
        {
            view2(navController = navController)
        }

        composable("view3")
        {
            view3(navController = navController)
        }


    }
}