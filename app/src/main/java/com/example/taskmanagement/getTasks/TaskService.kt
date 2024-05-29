package com.example.taskmanagement.getTasks

import com.example.taskmanagement.MockData.Task
import retrofit2.http.GET

interface TaskService {
    @GET("tasks")
    suspend fun getTasks(): List<Task>

}