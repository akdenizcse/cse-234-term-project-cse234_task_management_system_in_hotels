package com.example.taskmanagement.getTasks

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class TaskViewModel : ViewModel() {
    var responseState = mutableStateOf<ApiResponsee<TasksData>?>(null)
    var errorState = mutableStateOf<String?>(null)
    var tasksState = mutableStateOf<List<TaskData>?>(emptyList())
    var updateResultState = mutableStateOf<ApiResponsee<IdData>?>(null)
    var _data = MutableStateFlow<List<TaskData>>(emptyList())
    var data: StateFlow<List<TaskData>> = _data


        fun getTasksByUserID(userId: String) {
            println("Fetching tasks for user ID: $userId")
            viewModelScope.launch {

                try {
                    println("Launching coroutine to fetch tasks")
                    val response =
                        RetrofitInstance.taskRetrofit.getTasksByUserID(userId).awaitResponse()
                    println("Response received")

                    if (response.isSuccessful) {
                        println("Response is successful")
                        responseState.value = response.body()
                        val taskData = response.body()?.Data
                        println("Parsed task data: $taskData")
                        tasksState.value = taskData?.tasks
                        _data.value = taskData?.tasks ?: emptyList()
                    } else {
                        println("Response is not successful: ${response.code()} - ${response.message()}")
                        errorState.value = "Error: ${response.code()} - ${response.message()}"
                    }
                } catch (e: Exception) {
                    println("Exception caught: ${e.message}")
                    errorState.value = e.message
                }


    }}

    fun updateTaskStatus(taskId: String, status: Int) {
        viewModelScope.launch {
            try {
                val response =
                    RetrofitInstance.taskRetrofit.updateTaskStatus(taskId, status).awaitResponse()
                if (response.isSuccessful) {
                    updateResultState.value = response.body()
                }
            } catch (e: Exception) {
                errorState.value = e.message
            }
        }
    }
}