package com.example.taskmanagement.MockDataockData

import com.example.taskmanagement.MockData.Status
import com.example.taskmanagement.MockData.Task


object MockData {
    fun getTasks(): List<Task> {
        return listOf(
            Task(1,"Task 1","Task 1 Description", Status.Todo),
            Task(2,"Task 2","Task 2 Description", Status.Todo),
            Task(3,"Task 3","Task 3 Description", Status.InProgress),
            Task(4,"Task 4","Task 4 Description", Status.InProgress),
            Task(5,"Task 5","Task 5 Description", Status.Done),
            Task(6,"Task 6","Task 6 Description", Status.Done),

        )
    }
}