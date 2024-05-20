package com.example.taskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.navigation.compose.rememberNavController
import com.example.taskmanagement.uiScreens.Dashboard
import com.example.taskmanagement.uiScreens.DashboardInProgress
import com.example.taskmanagement.uiScreens.Schedule


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Schedule(navController = rememberNavController())
            }

        }
    }

}











