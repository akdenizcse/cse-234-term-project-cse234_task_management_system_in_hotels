package com.example.taskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskmanagement.login.LoginScreen
import com.example.taskmanagement.uiScreens.Dashboard
import com.example.taskmanagement.uiScreens.DashboardInProgress


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            //ekranları birbirine bağlama
            NavHost(navController = navController, startDestination = "LoginScreen", builder = {
                composable(route = "LoginScreen") {
                    LoginScreen(navController)
                }
                //daha sonra buraya parametre gönderme ekleyeceğiz
                composable(route = "Dashboard") {
                    Column {


                        Dashboard("enver", "Untuç", "manager")
                        Spacer(modifier = Modifier.height(30.dp))
                        DashboardInProgress()
                    }
                }
              /*  composable(route = "Schedule"){
                    Schedule(navController)

                }
                composable(route = "Profile"){
                    Profile(navController)

                }*/
            })

        }
    }

}











