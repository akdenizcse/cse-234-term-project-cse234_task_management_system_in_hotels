package com.example.taskmanagement.MockData

enum class Status{
    Todo,
    InProgress,
    Done
}

data class Task(val id : Int,val title: String,val description:String,var status: Status)
