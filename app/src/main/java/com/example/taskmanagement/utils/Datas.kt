package com.example.azureexp.utils


interface Common {
}


data class UserData(
    val id: String,
    val userName: String,
    val email: String,
    val roles: List<String>,
    val departmentId: String,
    val boardId: String,
    val isVerified: Boolean,
    val jwToken: String
) : Common

data class TaskData(

    val id: String,
    val createdBy: String,
    val created: String,
    val lastModifiedBy: String,
    val lastModified: String,
    val title: String,
    val description: String,
    val boardId: String,
    val departmentId: String,
    val status: Int

) : Common

data class IdData(
    val id: String
) : Common
data class TasksData(
    val tasks: List<TaskData>
) : Common
