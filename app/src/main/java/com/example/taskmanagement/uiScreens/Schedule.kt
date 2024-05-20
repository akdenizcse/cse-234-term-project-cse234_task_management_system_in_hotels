package com.example.taskmanagement.uiScreens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.taskmanagement.login.RetrofitInstance
import com.example.taskmanagement.getTasks.Status
import com.example.taskmanagement.getTasks.Task
import kotlinx.coroutines.launch

@Composable
fun Schedule(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val tasks = remember { mutableStateOf(emptyList<Task>()) }

    LaunchedEffect(Unit ) {
        coroutineScope.launch {
            tasks.value = RetrofitInstance.taskService.getTasks()
        }

    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.padding(top = 16.dp)) {
            val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
            daysOfWeek.forEach { day ->
                Surface(
                    shape = CircleShape,
                    border = BorderStroke(1.dp, Color.Gray),
                    modifier = Modifier
                        .size(30.dp)
                        .padding(horizontal = 4.dp)
                ) {
                    Text(
                        text = day,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 10.sp
                    )
                }
            }
        }
        Text(
            text = "To do Tasks",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black,


            )
        Spacer(modifier = Modifier.height(10.dp))
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
        Column {

            for (task in tasks.value) {
                if (task.status == Status.Todo){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedCard(
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = "Task ID: ${task.id}", fontWeight = FontWeight.Bold)
                                Text(text = task.title, fontWeight = FontWeight.Bold)
                                Text(text = task.description)
                            }
                        }
                        Button(
                            onClick = { task.status = Status.InProgress },
                            modifier = Modifier.align(Alignment.CenterVertically)
                        ) {
                            Text(text = "make inprogress")
                        }
                    }
                }}
        }
    }
}