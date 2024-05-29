package com.example.taskmanagement.getTasks


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface TaskService {
    @GET("api/Account/users/{userId}/tasks")
    suspend fun getTasksByUserID(@Path("userId") userId: String): Call<ApiResponsee<TasksData>>

    @PUT("api/v1.0/UserTask/{taskId}/task-status")
    suspend fun updateTaskStatus(@Path("taskId") taskId: String,@Query ("status") status: Int): Call<ApiResponsee<IdData>>
}


