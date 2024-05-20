package com.example.taskmanagement.getTasks

enum class Status{
    Todo,
    InProgress,
    Done
}

data class Task(val id : Int,val title: String,val description:String,var status: Status)
