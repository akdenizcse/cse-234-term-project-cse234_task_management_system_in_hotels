package com.example.taskmanagement.login

import com.example.taskmanagement.getTasks.TaskService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://taskmanagementsysteminhotels.azurewebsites.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val userRetrofit: UserService by lazy {
        retrofit.create(UserService::class.java)
    }

    val taskRetrofit: TaskService by lazy {
        retrofit.create(TaskService::class.java)
    }


}