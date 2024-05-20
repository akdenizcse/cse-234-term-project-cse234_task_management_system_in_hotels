package com.example.taskmanagement.getTasks

import retrofit2.http.GET

interface TaskService {
    @GET("tasks")
    suspend fun getTasks(): List<Task>

}