package com.example.taskmanagement.login

import com.example.azureexp.utils.Common
import com.example.azureexp.utils.UserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val email: String, val password: String)

data class ApiResponse<T : Common>(
    val succeeded: Boolean,
    val message: String,
    val errors: List<String>,
    val data: T
)

data class ApiResponsee<T : Common>(
    val Succeeded: Boolean,
    val Message: String,
    val Errors: List<String>,
    val Data: T
)


interface UserService {
    @POST("api/Account/authenticate")
    fun login(@Body request: LoginRequest): Call<ApiResponse<UserData>>
}