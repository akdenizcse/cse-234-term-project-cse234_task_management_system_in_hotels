package com.example.taskmanagement.uiScreens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.azureexp.utils.TaskData
import com.example.azureexp.utils.UserRepository
import com.example.taskmanagement.getTasks.TaskViewModel

@Composable
fun InprogressTasks(navController: NavController) {
    val taskViewModel = TaskViewModel()
    val context = LocalContext.current
    val userRepository = UserRepository(context)
    val userID = userRepository.userID.collectAsState(initial = null)

    if(userID.value != null){
        taskViewModel.getTasksByUserID(userID.value.toString())
    }
    // get the tasks
    //val tasks = taskViewModel.tasksState.value
    //create mock data of TaskData list
    val tasks = listOf(
        TaskData("1", "Task 1", "Task 1 Description", "haydar", "20204082", "Task1", "clean the rooms and bathrooms", "1", "1", 2),
        TaskData("2", "Task 2", "Task 2 Description", "haydar", "20204082", "Task2", "", "1", "1", 0),
        TaskData("3", "Task 3", "Task 3 Description", "haydar", "20204082", "Task3", "do the laundry", "1", "1", 1),
        TaskData("4", "Task 4", "Task 4 Description", "haydar", "20204082", "Task4", "do the homework", "1", "1", 1),
    )
    println("AAAAAAAAAAAAAAA")
    println(tasks);
    Column {


        Text(text = "InprogressTasks")
        if (userID.value != null){
            Text(text = "User ID: ${userID.value}")
            if(tasks != null){
                // Display the tasks
                for (task in tasks){
                    TaskCard(task = task, taskViewModel = taskViewModel,navController)
                }
            }
            else{
                Text(text = "Tasks: null")
            }
        }
        else{
            Text(text = "User ID: null")
        }


    }
}