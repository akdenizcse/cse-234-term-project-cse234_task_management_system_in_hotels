package com.example.taskmanagement.GetTasks

import retrofit2.http.GET

interface TaskService {
    @GET("tasks")
    suspend fun getTasks(): List<Task>

}