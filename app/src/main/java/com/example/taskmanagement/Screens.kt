package com.example.taskmanagement

sealed class Screens (val screen : String){
    data object EntryScreen : Screens ("entryScreen")
    data object Profile : Screens ("profile")
    data object Tasks : Screens ("tasks")
}