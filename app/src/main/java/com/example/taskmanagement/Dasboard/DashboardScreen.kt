package com.example.taskmanagement.Dasboard

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {
    Column {
        HeaderUI("Enver", "Untuç", "Student")
        TaskCardUI(navController)
        StatisticUI()
        DescriptionUI()
    }
}