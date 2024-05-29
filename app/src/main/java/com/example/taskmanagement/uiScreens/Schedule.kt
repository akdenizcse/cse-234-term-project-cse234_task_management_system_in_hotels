package com.example.taskmanagement.uiScreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.taskmanagement.MockData.Status
import com.example.taskmanagement.MockData.Task
import com.example.taskmanagement.MockDataockData.MockData

@Composable
fun Schedule(navController: NavController) {

    val tasks = remember { mutableStateOf(MockData.getTasks()) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "To Do Tasks",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(10.dp))

        val todoTasks = tasks.value.filter { it.status == Status.Todo } // Filter Todo tasks

        if (todoTasks.isEmpty()) {
            Text(
                text = "No Todo Tasks",
                fontSize = 16.sp,
                color = Color.Gray,
            )
        } else {
            Column {
                todoTasks.forEach { task ->
                    TaskCard(task = task, onStatusChange = { tasks.value = tasks.value.map { if (it.id == task.id) it.copy(status = Status.Done) else it } }) {
                        // Handle navigation if needed (optional)
                        navController.navigate("detailScreen/${task.id}") // Example navigation
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun TaskCard(
    task: Task,
    onStatusChange: (Task) -> Unit,
    onClick: () -> Unit, // Optional click action
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.clickable { onClick() }, // Optional click action
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = { onStatusChange(task.copy(status = Status.InProgress)) },
            ) {
                Text("Start")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = task.title, fontWeight = FontWeight.Bold)
                Text(text = task.description, color = Color.Gray)
            }
        }
    }
}
