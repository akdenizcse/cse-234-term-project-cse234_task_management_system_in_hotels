package com.example.taskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskmanagement.dashboard.DashboardScreen
import com.example.taskmanagement.login.LoginScreen
import com.example.taskmanagement.uiScreens.InprogressTasks
import com.example.taskmanagement.uiScreens.ProfileScreen
import com.example.taskmanagement.uiScreens.Schedule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "login") {
                composable("login") {
                    LoginScreen(navController = navController)
                }
                composable("DashboardScreen") {
                    DashboardScreen(navController = navController)
                }
                composable("profile") {
                    ProfileScreen(navController = navController)
                }
                composable("schedule") {
                    Schedule(navController = navController)
                }
                composable("inprogressTasks") {
                    Column {
                        InprogressTasks(navController = navController)
                        Row {
                            Button(onClick = {
                                navController.navigate("DashboardScreen")
                            }) {
                                Text(text = "Go to Dashboard")
                            }
                            Spacer(modifier = Modifier.width(width = 80.dp))
                            Button(onClick = {
                                navController.navigate("profile")
                            }) {
                                Text(text = "Go to Profile")
                            }
                        }
                    }


                }

            }
        }

    }
}











