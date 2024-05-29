package com.example.taskmanagement

sealed class Screens (val route: String){
    data object LoginScreen : Screens("LoginScreen")
    data object Dashboard : Screens ("Dashboard")
    data object Profile : Screens ("profile")
    data object Schedule : Screens ("Schedule")

}