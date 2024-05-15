package com.example.taskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


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


                        Dashboard("enver", "Untuç", "cleaner")
                        Spacer(modifier = Modifier.height(30.dp))
                        DashboardInProgress()
                        Button(onClick = { navController.navigate(route = "Schedule") }) {
                            Text(text = "To see todo tasks")
                            
                        }
                    }
                }
                composable(route = "Schedule"){
                    Schedule(navController)

                }
                composable(route = "Profile"){
                    Profile(navController)

                }
            })


        }
    }
}








