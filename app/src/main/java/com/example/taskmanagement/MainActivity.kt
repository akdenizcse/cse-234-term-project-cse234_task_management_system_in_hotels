package com.example.taskmanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskmanagement.UIScreens.Dashboard
import com.example.taskmanagement.UIScreens.DashboardInProgress
import com.example.taskmanagement.Login.LoginScreen
import com.example.taskmanagement.UIScreens.Profile
import com.example.taskmanagement.UIScreens.Schedule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {


                Dashboard(name = "enver", surname = "ut", job = "aa")
                DashboardInProgress()
            }

        }
    }

}











